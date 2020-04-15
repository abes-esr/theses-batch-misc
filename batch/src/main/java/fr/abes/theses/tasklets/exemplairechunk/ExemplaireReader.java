package fr.abes.theses.tasklets.exemplairechunk;

import fr.abes.theses.model.dto.NoticeBiblioDto;
import fr.abes.theses.model.entities.NoticeBiblio;
import fr.abes.theses.service.ServiceProvider;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    public ExemplaireReader(ServiceProvider service) {
        this.service = service;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("entree dans beforeStep de ExemplaireReader");

        this.noticeBiblios = new ArrayList<>();
        Integer jobId = stepExecution.getJobExecutionId().intValue();
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
