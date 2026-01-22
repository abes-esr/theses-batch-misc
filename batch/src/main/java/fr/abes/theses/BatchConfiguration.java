package fr.abes.theses;

import fr.abes.theses.configuration.ThesesOracleConfig;
import fr.abes.theses.listener.DefaultListenerSupport;
import fr.abes.theses.tasklets.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Slf4j
@Configuration
@EnableBatchProcessing
@Import(ThesesOracleConfig.class)
@EnableRetry
public class BatchConfiguration {
    private final JobBuilderFactory jobs;

    private final StepBuilderFactory steps;

    private final DataSource thesesDatasource;

    public BatchConfiguration(JobBuilderFactory jobs, StepBuilderFactory steps, DataSource thesesDatasource) {
        this.jobs = jobs;
        this.steps = steps;
        this.thesesDatasource = thesesDatasource;
    }

    @Bean
    public BatchConfigurer configurer(EntityManagerFactory entityManagerFactory) throws Exception {
        return new ThesesBatchConfigurer(thesesDatasource, entityManagerFactory);
    }

    /**
     * Job de rediffusion des notices de STAR dans le Sudoc (uniquement notices bibliographiques)
     *
     * @return
     */
    @Bean
    public Job jobRediffusionNoticesBiblio(@Qualifier("noticeBiblioReader") ItemReader reader,
                                           @Qualifier("noticeBiblioProcessor") ItemProcessor processor,
                                           @Qualifier("noticeBiblioWriter") ItemWriter writer) {
        log.info("Début du batch de rediffusion des notices de STAR en notices bibliographique Sudoc");

        return jobs
                .get("diffuserThesesVersSudoc").incrementer(incrementer())
                .start(stepSelectThesesStarARediff()).on("FAILED").end()
                .from(stepSelectThesesStarARediff()).on("AUCUNE NOTICE").end()
                .from(stepSelectThesesStarARediff()).on("COMPLETED").to(stepSelectNoticesBibliosATraiter())
                .from(stepSelectNoticesBibliosATraiter()).on("FAILED").end()
                .from(stepSelectNoticesBibliosATraiter()).on("COMPLETED").to(stepAuthentifierToSudoc())
                .from(stepAuthentifierToSudoc()).on("FAILED").end()
                .from(stepAuthentifierToSudoc()).on("COMPLETED").to(stepDiffuserNoticeBiblio(reader, processor, writer))
                .from(stepDiffuserNoticeBiblio(reader, processor, writer)).on("FAILED").to(stepDisconnect())
                .from(stepDiffuserNoticeBiblio(reader, processor, writer)).on("COMPLETED").to(stepGenererFichier())
                .from(stepGenererFichier()).on("*").to(stepSupprimerIdsEnvoiSudocBdd())
                .next(stepDisconnect())
                .build().build();
    }

    @Bean
    public Job jobRediffusionNoticesExemplaires(@Qualifier("exemplaireReader") ItemReader reader,
                                                @Qualifier("exemplaireProcessor") ItemProcessor processor,
                                                @Qualifier("exemplaireWriter") ItemWriter writer) {
        log.info("Début du batch de rediffusion des exemplaires de notices star dans le Sudoc");

        return jobs
                .get("diffuserExemplairesThesesVersSudoc").incrementer(incrementer())
                .start(stepSelectThesesStarARediff()).on("FAILED").end()
                .from(stepSelectThesesStarARediff()).on("AUCUNE NOTICE").end()
                .from(stepSelectThesesStarARediff()).on("COMPLETED").to(stepSelectNoticesBibliosATraiter())
                .from(stepSelectNoticesBibliosATraiter()).on("FAILED").end()
                .from(stepSelectNoticesBibliosATraiter()).on("COMPLETED").to(stepDiffuserExemp(reader, processor, writer))
                .from(stepDiffuserExemp(reader, processor, writer)).on("FAILED").end()
                .from(stepDiffuserExemp(reader, processor, writer)).on("COMPLETED").to(stepGenererFichier())
                .from(stepGenererFichier()).on("*").to(stepSupprimerIdsEnvoiSudocBdd())
                .end()
                .build();
    }

    // ------------------ INCREMENTER ------------------
    protected JobParametersIncrementer incrementer() {
        return new TimeIncrementer();
    }

    @Bean
    public Step stepSelectThesesStarARediff() {
        return steps.get("selectThesesStarARediff").allowStartIfComplete(true)
                .tasklet(selectThesesStarARedifTasklet()).build();
    }

    @Bean
    public Step stepSelectNoticesBibliosATraiter() {
        return steps.get("selectNoticesBibliosATraiter").allowStartIfComplete(true)
                .tasklet(selectNoticesBibliosATraiter()).build();
    }

    @Bean
    public Step stepSupprimerIdsEnvoiSudocBdd() {
        return steps.get("stepSupprimerIdsEnvoiSudocBdd")
                .tasklet(supprimerIdsEnvoiSudocBddTasklet()).build();
    }

    @Bean
    public Step stepAuthentifierToSudoc() {
        return steps.get("authentifierToSudoc").allowStartIfComplete(true)
                .tasklet(authentifierToSudocTasklet()).build();
    }

    @Bean
    public Step stepDiffuserNoticeBiblio(@Qualifier("noticeBiblioReader") ItemReader reader,
                                         @Qualifier("noticeBiblioProcessor") ItemProcessor processor,
                                         @Qualifier("noticeBiblioWriter") ItemWriter writer) {

        ExponentialBackOffPolicy exponentialBackOffPolicy = new ExponentialBackOffPolicy();
        exponentialBackOffPolicy.setInitialInterval(2000);
        exponentialBackOffPolicy.setMultiplier(3);
        exponentialBackOffPolicy.setMaxInterval(500000);

        return steps.get("diffuserNoticeBiblio").chunk(10)
                .reader(reader) //on lit iddoc dans star
                .processor(processor) //on transfo tef to unimarc + ecrire dans le sudoc
                .writer(writer) //écrire dans fichier résultat bilan opération
                .faultTolerant()
                .retry(Exception.class)
                .retryLimit(6)
                .listener(new DefaultListenerSupport())
                .backOffPolicy(exponentialBackOffPolicy)
                .skip(Exception.class)
                .skipLimit(1000)
                .backOffPolicy(exponentialBackOffPolicy)
                .build();
    }

    @Bean
    public Step stepDiffuserExemp(@Qualifier("exemplaireReader") ItemReader reader,
                                  @Qualifier("exemplaireProcessor") ItemProcessor processor,
                                  @Qualifier("exemplaireWriter") ItemWriter writer) {

        ExponentialBackOffPolicy exponentialBackOffPolicy = new ExponentialBackOffPolicy();
        exponentialBackOffPolicy.setInitialInterval(2000);
        exponentialBackOffPolicy.setMultiplier(3);
        exponentialBackOffPolicy.setMaxInterval(500000);

        return steps.get("diffuserNoticeExemp")
                .chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .faultTolerant()
                .retry(Exception.class)
                .retryLimit(6)
                .listener(new DefaultListenerSupport())
                .backOffPolicy(exponentialBackOffPolicy)
                .skip(Exception.class)
                .skipLimit(1000)
                .build();
    }

    @Bean
    public Step stepGenererFichier() {
        return steps
                .get("stepGenererFichier").allowStartIfComplete(true)
                .tasklet(genererFichierTasklet())
                .build();
    }

    @Bean
    public Step stepDisconnect() {
        return steps
                .get("stepDisconnect").allowStartIfComplete(true)
                .tasklet(disconnectTasklet())
                .build();
    }

    @Bean
    public SelectThesesStarARedifTasklet selectThesesStarARedifTasklet() {
        return new SelectThesesStarARedifTasklet();
    }

    @Bean
    public SelectNoticesBibliosATraiter selectNoticesBibliosATraiter() {
        return new SelectNoticesBibliosATraiter();
    }

    @Bean
    public SupprimerIdsEnvoiSudocBddTasklet supprimerIdsEnvoiSudocBddTasklet() {
        return new SupprimerIdsEnvoiSudocBddTasklet();
    }

    @Bean
    public AuthentifierToSudocTasklet authentifierToSudocTasklet() {
        return new AuthentifierToSudocTasklet();
    }

    @Bean
    public GenererFichierTasklet genererFichierTasklet() {
        return new GenererFichierTasklet();
    }

    @Bean
    public DisconnectTasklet disconnectTasklet() {
        return new DisconnectTasklet();
    }

}
