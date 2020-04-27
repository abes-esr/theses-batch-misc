package fr.abes.theses.tasklets;

import fr.abes.cbs.exception.CBSException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class AuthentifierToSudocTasklet implements Tasklet, StepExecutionListener {
    @Autowired
    ProxyRetry proxyRetry;

    @Value("${sudoc.loginM4001}")
    private String login;

    @Value("${sudoc.passwdM4001}")
    private String passwd;

    @Override
    public void beforeStep(StepExecution stepExecution) {
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
            this.proxyRetry.authenticate(login, passwd);
            log.info("connexion OK");
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
