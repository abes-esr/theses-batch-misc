package fr.abes.theses.tasklets;

import fr.abes.theses.model.dto.NoticeBiblioDto;
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

import java.util.ArrayList;
import java.util.List;

public class DiffuserNoticeExempTasklet implements Tasklet, StepExecutionListener {
    @Autowired
    @Getter
    ServiceProvider service;

    Integer jobId;
    private List<NoticeBiblioDto> noticeBiblios;

    DiffuserNoticeExempTasklet() {
        this.noticeBiblios = new ArrayList<>();
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        this.noticeBiblios = (List<NoticeBiblioDto>) stepExecution
                .getJobExecution()
                .getExecutionContext().get("noticesBiblio");
        this.jobId = stepExecution.getJobExecutionId().intValue();
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        if (ExitStatus.COMPLETED.equals(stepExecution.getExitStatus())) {
            stepExecution.getJobExecution().getExecutionContext().put("noticesBiblio", this.noticeBiblios);
        }
        return stepExecution.getExitStatus();
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        List<String> listeEtab = getService().getNoticeBiblioService().getCodeEtabNonTraiteByJobId(this.jobId);
        for (String etab : listeEtab) {

        }
        return RepeatStatus.FINISHED;
    }
}
