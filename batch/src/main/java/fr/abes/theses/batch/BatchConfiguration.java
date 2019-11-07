package fr.abes.theses.batch;

import fr.abes.theses.batch.tasklets.SelectDemandeATraiterTasklet;
import lombok.extern.log4j.Log4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Log4j
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Autowired
    private DataSource thesesDatasource;

    @Bean
    public BatchConfigurer configurer(EntityManagerFactory entityManagerFactory){
        return new ThesesBatchConfigurer(entityManagerFactory);
    }

    @Bean
    public Job selectDemandeATraiter() {
        log.info("Début du batch de sélection de la prochaine demande à traiter");

        return jobs.get("selectDemandeATraiter").incrementer(incrementer()).start(stepSelectDemandeATraiter()).on(ExitStatus.FAILED.getExitCode()).end().build().build();
    }


    // ------------------ INCREMENTER ------------------
    protected JobParametersIncrementer incrementer() {
        return new TimeIncrementer();
    }

    @Bean
    public Step stepSelectDemandeATraiter() {
        return steps.get("stepSelectDemandeATraiter").allowStartIfComplete(true)
                .tasklet(selectDemandeATraiterTaslet()).build();
    }

    @Bean
    public SelectDemandeATraiterTasklet selectDemandeATraiterTaslet() { return new SelectDemandeATraiterTasklet(); }



}
