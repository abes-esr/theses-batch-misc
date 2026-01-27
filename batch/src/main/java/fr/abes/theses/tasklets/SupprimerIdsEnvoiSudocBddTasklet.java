package fr.abes.theses.tasklets;

import fr.abes.theses.service.ServiceProvider;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class SupprimerIdsEnvoiSudocBddTasklet implements Tasklet {

    @Autowired
    @Getter
    ServiceProvider service;

    private String jobName;


    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        log.info("Suppression des ids envoi Sudoc dans la BDD");

        StepExecution stepExecution = chunkContext.getStepContext().getStepExecution();
        jobName = stepExecution.getJobExecution().getJobInstance().getJobName();

        if (jobName.equals("diffuserThesesVersSudoc")) {
            supprimerAllIds(chunkContext, "biblio");
        } else {
            supprimerAllIds(chunkContext, "exempl");
        }

        return RepeatStatus.FINISHED;
    }

    private void supprimerAllIds(ChunkContext chunkContext, String niveau) {
        List<Integer> ids= (List<Integer>) chunkContext.getStepContext()
                .getStepExecution()
                .getJobExecution()
                .getExecutionContext()
                .get("ids_"+ niveau);
        service.getDocumentService().deleteByIddocDeDocumentEnvoiSudoc(ids, niveau);
    }
}
