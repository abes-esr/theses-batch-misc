package fr.abes.theses.batch.tasklets.traiternoticebibliochunk;

import fr.abes.theses.batch.ligneFichierDto.LigneNoticeBiblioDto;
import fr.abes.theses.core.model.entities.NoticeBiblio;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class NoticeBiblioProcessor implements ItemProcessor<LigneNoticeBiblioDto, LigneNoticeBiblioDto>, StepExecutionListener {

    @Autowired
    StrategyFactory factory;

    @Autowired
    ProxyRetry proxyRetry;
    @Autowired
    @Getter
    ServiceProvider service;

    private NoticeBiblio noticeBiblio;


    @Override
    public void beforeStep(StepExecution stepExecution) {
        ExecutionContext executionContext = stepExecution
                .getJobExecution()
                .getExecutionContext();
        this.noticeBiblio = (NoticeBiblio) executionContext.get("noticeBiblio");
        log.info("...pour la noticeBiblio " + this.noticeBiblio.getId());
    }

    /**
     * This method allows the conversion from marcxml Star tef format (Star.Document) to marc sudoc database format
     *
     * @param fusion etc
     * @return
     * @throws
     */

    @Override
    public LigneNoticeBiblioDto process(LigneNoticeBiblioDto ligneFichierDto) throws Exception {

        try {
            int iddoc = ligneFichierDto.getIddoc();

        } catch (CBSException e) {
            log.error("erreur lors de la requête au Sudoc ou du saveExemplaire" + e.toString());
            ligneFichierDto.setRetourSudoc(e.getMessage());
        } catch (Exception e) {
            log.error("erreur lors de la recup de la noticetraitee : " + e.toString());
            ligneFichierDto.setRetourSudoc(e.getMessage());
        }
        return ligneFichierDto;
    }


    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}



