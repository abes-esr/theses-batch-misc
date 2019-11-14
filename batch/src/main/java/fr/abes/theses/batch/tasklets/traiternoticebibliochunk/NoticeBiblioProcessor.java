package fr.abes.theses.batch.tasklets.traiternoticebibliochunk;

import fr.abes.theses.batch.ligneFichierDto.LignesNoticeBiblioDto;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class NoticeBiblioProcessor implements ItemProcessor<LignesNoticeBiblioDto, LignesNoticeBiblioDto>, StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

    @Override
    public LignesNoticeBiblioDto process(LignesNoticeBiblioDto ligneFichierDto) throws Exception {
        return null;
    }
}
