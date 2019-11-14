package fr.abes.theses.batch.tasklets.traiternoticebibliochunk;

import fr.abes.theses.batch.ligneFichierDto.LignesNoticeBiblioDto;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoticeBiblioWriter implements ItemWriter<LignesNoticeBiblioDto>, StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

    @Override
    public void write(List<? extends LignesNoticeBiblioDto> list) throws Exception {

    }
}
