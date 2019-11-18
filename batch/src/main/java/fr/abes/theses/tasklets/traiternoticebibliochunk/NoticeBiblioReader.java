package fr.abes.theses.tasklets.traiternoticebibliochunk;

import fr.abes.theses.ligneFichierDto.LigneNoticeBiblioDto;
import fr.abes.theses.tasklets.ProxyRetry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class NoticeBiblioReader implements ItemReader<LigneNoticeBiblioDto>, StepExecutionListener {

    private List<LigneNoticeBiblioDto> lignesFichier;
    AtomicInteger i = new AtomicInteger();

    @Autowired
    ProxyRetry proxyRetry;


    @Override
    public void beforeStep(StepExecution stepExecution) {
        ExecutionContext executionContext = stepExecution
                .getJobExecution()
                .getExecutionContext();
        this.lignesFichier = (List<LigneNoticeBiblioDto>) executionContext.get("lignes");
    }

    /**
     * This method allows the reading of the iddoc in the STAR.Document table
     * @param
     * @return
     * @throws
     */
    @Override
    public LigneNoticeBiblioDto read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        LigneNoticeBiblioDto ligne = null;
        if (i.intValue() < this.lignesFichier.size()) {
            ligne = this.lignesFichier.get(i.getAndIncrement());
        }
        return ligne;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

}
