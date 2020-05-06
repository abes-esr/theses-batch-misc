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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SelectNoticesBibliosATraiter implements Tasklet, StepExecutionListener {
    @Autowired
    @Getter
    ServiceProvider service;

    @Value("${previousJobIdToRestartFrom}")
    private Integer previousJobIdToRestartFrom;

    private Integer jobId;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SelectNoticesBibliosATraiter() {
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        jobId = stepExecution.getJobExecutionId().intValue();
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        try {
            if (previousJobIdToRestartFrom != null && previousJobIdToRestartFrom != -1) {
                updateNoticesAlreadyDone(jobId);
                log.info("Job restarted from job : " + previousJobIdToRestartFrom);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return RepeatStatus.FINISHED;
    }

    private void updateNoticesAlreadyDone(Integer jobId) {
        jdbcTemplate.update("update T_E_TRAITEMENT_NOTICEBIB_TNB set TRAITEE=1 " +
                        "WHERE JOB_ID= ? " +
                        "and THE_ID in (select the_id from T_E_TRAITEMENT_NOTICEBIB_TNB where job_id= ? and traitee=1)",
                jobId,
                previousJobIdToRestartFrom);
        jdbcTemplate.update("commit");

    }
}
