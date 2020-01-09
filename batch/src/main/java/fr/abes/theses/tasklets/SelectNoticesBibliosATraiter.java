package fr.abes.theses.tasklets;

import fr.abes.theses.model.dto.NoticeBiblioDto;
import fr.abes.theses.model.entities.NoticeBiblio;
import fr.abes.theses.service.ServiceProvider;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
public class SelectNoticesBibliosATraiter implements Tasklet, StepExecutionListener {
    @Autowired @Getter
    ServiceProvider service;

    private List<NoticeBiblioDto> noticeBiblioDtos;
    private Integer jobId;

    public SelectNoticesBibliosATraiter() {
        noticeBiblioDtos = new ArrayList<>();
    }
    @Override
    public void beforeStep(StepExecution stepExecution) {
        jobId = stepExecution.getJobExecutionId().intValue();
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        if (ExitStatus.COMPLETED.equals(stepExecution.getExitStatus())) {
            stepExecution.getJobExecution().getExecutionContext().put("noticesBiblio", this.noticeBiblioDtos);
        }
        return stepExecution.getExitStatus();
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("Lancement Job n° " + jobId);
        for (NoticeBiblio noticeBiblio : getService().getNoticeBiblioService().getNoticesNonTraiteByJobId(jobId)) {
            this.noticeBiblioDtos.add(new NoticeBiblioDto(noticeBiblio));
        }
        if (this.noticeBiblioDtos.isEmpty()) {
            log.error("Aucune notice à traiter pour le job " + jobId);
            stepContribution.setExitStatus(ExitStatus.FAILED);
        }

        return RepeatStatus.FINISHED;
    }
}