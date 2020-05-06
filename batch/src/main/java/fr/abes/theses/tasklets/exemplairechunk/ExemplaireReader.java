package fr.abes.theses.tasklets.exemplairechunk;

import fr.abes.theses.model.dto.NoticeBiblioDto;
import fr.abes.theses.model.entities.NoticeBiblio;
import fr.abes.theses.service.ServiceProvider;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class ExemplaireReader implements ItemReader<NoticeBiblioDto>, StepExecutionListener {

    private List<NoticeBiblioDto> noticeBiblios;
    private AtomicInteger i = new AtomicInteger();
    @Getter
    final ServiceProvider service;

    private final JdbcTemplate jdbcTemplate;

    public ExemplaireReader(ServiceProvider service, JdbcTemplate jdbcTemplate) {
        this.service = service;
        this.jdbcTemplate = jdbcTemplate;
    }

    @SneakyThrows
    @Override
    public void beforeStep(StepExecution stepExecution) {

        Integer jobId = stepExecution.getJobExecutionId().intValue();

        log.info("BeforeStep de ExemplaireReader");
        this.noticeBiblios = new ArrayList<>();
        List<NoticeBiblio> NoticeBiblios = getService().getNoticeBiblioService().getNoticesNonTraiteByJobId(jobId);
        for (NoticeBiblio noticeBiblio : NoticeBiblios) {
            this.noticeBiblios.add(new NoticeBiblioDto(noticeBiblio));
        }
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

    @Override
    public NoticeBiblioDto read() {
        NoticeBiblioDto noticeBiblio = null;
        if (i.intValue() < this.noticeBiblios.size()) {
            noticeBiblio = this.noticeBiblios.get(i.getAndIncrement());
        }
        return noticeBiblio;
    }
}
