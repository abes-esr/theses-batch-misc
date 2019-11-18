package fr.abes.theses.tasklets;

import fr.abes.cbs.exception.CBSException;
import fr.abes.theses.ligneFichierDto.LigneNoticeBiblioDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class AuthentifierToSudocTasklet implements Tasklet, StepExecutionListener {
    private List<LigneNoticeBiblioDto> lignesFichier;
    @Autowired
    ProxyRetry proxyRetry;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        ExecutionContext executionContext = stepExecution
                .getJobExecution()
                .getExecutionContext();
        this.lignesFichier = (List<LigneNoticeBiblioDto>) executionContext.get("lignes");
    }

    /**
     * step allowing the program to authenticate to Sudoc database
     * @param stepContribution
     * @param chunkContext
     * @return
     * @throws Exception
     */

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("Entrée dans AuthentifierToSudocTasklet");

        try
        {
            this.proxyRetry.authenticate();
        }
        catch (CBSException e)
        {
            log.error("Impossible de se connecter au Sudoc : " + e.toString());
            stepContribution.setExitStatus(ExitStatus.FAILED);
        }
        return RepeatStatus.FINISHED;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        if (stepExecution.getJobExecution().getExitStatus().equals(ExitStatus.FAILED)) {
            return ExitStatus.FAILED;
        }
        return ExitStatus.COMPLETED;
    }
}
