package fr.abes.theses.tasklets.exemplairechunk;

import fr.abes.theses.model.dto.NoticeBiblioDto;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExemplaireWriter implements ItemWriter<NoticeBiblioDto>, StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

    @Override
    public void write(List<? extends NoticeBiblioDto> list) throws Exception {

    }
}
