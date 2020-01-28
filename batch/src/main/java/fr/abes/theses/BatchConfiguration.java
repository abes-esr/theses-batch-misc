package fr.abes.theses;

import fr.abes.theses.configuration.ThesesOracleConfig;
import fr.abes.theses.tasklets.*;
import lombok.extern.log4j.Log4j;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.retry.annotation.EnableRetry;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Log4j
@Configuration
@EnableBatchProcessing
@Import(ThesesOracleConfig.class)
@EnableRetry
public class BatchConfiguration {
    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Autowired
    DataSource thesesDatasource;

    @Bean
    public BatchConfigurer configurer(EntityManagerFactory entityManagerFactory) throws Exception{
        return new ThesesBatchConfigurer(thesesDatasource, entityManagerFactory);
    }

    /**
     * Job de rediffusion des notices de STAR dans le Sudoc (uniquement notices bibliographiques)
     * @return
     */
    @Bean
    public Job jobRediffusionNoticesBiblio(ItemReader itemReader, ItemProcessor itemProcessor, ItemWriter itemWriter) {
        log.info("Début du batch de rediffusion des notices de STAR en notices bibliographique Sudoc");

        return jobs
                .get("diffuserThesesVersSudoc").incrementer(incrementer())
                .start(stepSelectThesesStarARediff()).on("FAILED").end()
                .from(stepSelectThesesStarARediff()).on("AUCUNE NOTICE").end()
                .from(stepSelectThesesStarARediff()).on("COMPLETED").to(stepSelectNoticesBibliosATraiter())
                .from(stepSelectNoticesBibliosATraiter()).on("FAILED").end()
                .from(stepSelectNoticesBibliosATraiter()).on("COMPLETED").to(stepAuthentifierToSudoc())
                .from(stepAuthentifierToSudoc()).on("FAILED").end()
                .from(stepAuthentifierToSudoc()).on("COMPLETED").to(stepDiffuserNoticeBiblio(itemReader, itemProcessor, itemWriter))
                .from(stepDiffuserNoticeBiblio(itemReader, itemProcessor, itemWriter)).on("FAILED").to(stepDisconnect())
                .from(stepDiffuserNoticeBiblio(itemReader, itemProcessor, itemWriter)).on("COMPLETED").to(stepGenererFichier())
                .from(stepGenererFichier()).next(stepDisconnect())
                .build().build();
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
    public Step stepAuthentifierToSudoc() {
        return steps.get("authentifierToSudoc").allowStartIfComplete(true)
                .tasklet(authentifierToSudocTasklet()).build();
    }

    @Bean
    public Step stepDiffuserNoticeBiblio(ItemReader reader, ItemProcessor processor, ItemWriter writer) {
        return steps.get("diffuserNoticeBiblio").chunk(10)
                .reader(reader) //on lit iddoc dans star
                .processor(processor) //on transfo tef to unimarc
                .writer(writer) //ecrire dans le sudoc + dire dans bdd
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
    public SelectThesesStarARedifTasklet selectThesesStarARedifTasklet() { return new SelectThesesStarARedifTasklet(); }

    @Bean
    public SelectNoticesBibliosATraiter selectNoticesBibliosATraiter() { return new SelectNoticesBibliosATraiter(); }

    @Bean
    public AuthentifierToSudocTasklet authentifierToSudocTasklet() { return new AuthentifierToSudocTasklet(); }

    @Bean
    public GenererFichierTasklet genererFichierTasklet() { return new GenererFichierTasklet(); }

    @Bean
    public DisconnectTasklet disconnectTasklet() {return new DisconnectTasklet();}

}
