package fr.abes.theses.tasklets.exemplairechunk;

import fr.abes.theses.model.dto.NoticeBiblioDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class ExemplaireReader implements ItemReader<NoticeBiblioDto>, StepExecutionListener {

    private List<NoticeBiblioDto> noticeBiblios;
    private AtomicInteger i = new AtomicInteger();

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("entree dans beforeStep de NoticeBiblioReader");
        ExecutionContext executionContext = stepExecution
                .getJobExecution()
                .getExecutionContext();
        this.noticeBiblios = (List<NoticeBiblioDto>) executionContext.get("noticesBiblio");
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
