package fr.abes.theses.tasklets;

import fr.abes.theses.service.ServiceProvider;
import lombok.Getter;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

public class DisconnectTasklet implements Tasklet, StepExecutionListener {
    @Autowired @Getter
    ServiceProvider service;

    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        if (stepExecution.getJobExecution().getExitStatus().equals(ExitStatus.FAILED)) {
            return ExitStatus.FAILED;
        }
        return ExitStatus.COMPLETED;
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        this.getService().getMajStarSudocService().disconnectBiblio();
        return RepeatStatus.FINISHED;
    }
}
