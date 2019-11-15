package fr.abes.theses.batch.tasklets.traiternoticebibliochunk;

import fr.abes.theses.batch.ligneFichierDto.LigneNoticeBiblioDto;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

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
