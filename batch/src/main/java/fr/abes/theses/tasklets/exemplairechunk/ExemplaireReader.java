package fr.abes.theses.tasklets.exemplairechunk;

import fr.abes.theses.model.dto.NoticeBiblioDto;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class ExemplaireReader implements ItemReader<NoticeBiblioDto>, StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

    @Override
    public NoticeBiblioDto read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return null;
    }
}
