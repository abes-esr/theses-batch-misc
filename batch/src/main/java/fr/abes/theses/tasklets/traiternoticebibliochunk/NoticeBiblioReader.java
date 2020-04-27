package fr.abes.theses.tasklets.traiternoticebibliochunk;

import fr.abes.theses.model.dto.NoticeBiblioDto;
import fr.abes.theses.service.ServiceProvider;
import fr.abes.theses.thesesAccessLayer.model.entities.star.NoticeBiblio;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class NoticeBiblioReader implements ItemReader<NoticeBiblioDto>, StepExecutionListener {

    private List<NoticeBiblioDto> noticeBiblios;
    private AtomicInteger i = new AtomicInteger();

    @Getter
    final ServiceProvider service;

    public NoticeBiblioReader(ServiceProvider service) {
        this.service = service;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("entree dans beforeStep de NoticeBiblioReader");
        this.noticeBiblios = new ArrayList<>();
        Integer jobId = stepExecution.getJobExecutionId().intValue();
        List<NoticeBiblio> NoticeBiblios = getService().getNoticeBiblioService().getNoticesNonTraiteByJobId(jobId);
        for (NoticeBiblio noticeBiblio : NoticeBiblios) {
            this.noticeBiblios.add(new NoticeBiblioDto(noticeBiblio));
        }
    }

    /**
     * This method allows the reading of the iddoc in the STAR.Document table
     * @param
     * @return
     * @throws
     */
    @Override
    public NoticeBiblioDto read()  {

        NoticeBiblioDto noticeBiblio = null;
        if (i.intValue() < this.noticeBiblios.size()) {
            noticeBiblio = this.noticeBiblios.get(i.getAndIncrement());
        }
        return noticeBiblio;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

}
