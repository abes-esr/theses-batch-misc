package fr.abes.theses.tasklets.traiternoticebibliochunk;

import fr.abes.theses.model.dto.NoticeBiblioDto;
import fr.abes.theses.service.ServiceProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class NoticeBiblioReader implements ItemReader<NoticeBiblioDto>, StepExecutionListener {

    private List<NoticeBiblioDto> noticeBiblios;
    private AtomicInteger i = new AtomicInteger();

    public NoticeBiblioReader() {
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("entree dans beforeStep de NoticeBiblioReader");
        ExecutionContext executionContext = stepExecution
                .getJobExecution()
                .getExecutionContext();
        this.noticeBiblios = (List<NoticeBiblioDto>) executionContext.get("noticesBiblio");

        log.info("NoticeBibReader beforeStep size noticebib : " + this.noticeBiblios.size());
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
