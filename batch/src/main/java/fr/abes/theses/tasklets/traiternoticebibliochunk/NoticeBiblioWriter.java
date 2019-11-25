package fr.abes.theses.tasklets.traiternoticebibliochunk;

import fr.abes.theses.model.entities.NoticeBiblio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class NoticeBiblioWriter implements ItemWriter<NoticeBiblio>, StepExecutionListener {

   /* @Autowired
    private StrategyFactory factory;

    private IMailer mailer;
    private ILigneNoticeBiblio ligneFichierService;
    private IDemandeService demandeService;
    private List<LigneFichierDto> lignesFichier;
    private Demande demande;*/





    @Override
    public void beforeStep(StepExecution stepExecution) {
      /*  ExecutionContext executionContext = stepExecution
                .getJobExecution()
                .getExecutionContext();
        this.lignesNoticeBiblio = (List<LigneFichierDto>) executionContext.get("lignes");
        this.demande = (Demande) executionContext.get("demande");
        this.ligneFichierService = factory.getStrategy(ILigneFichierService.class, demande.getTypeDemande());
        this.demandeService = factory.getStrategy(IDemandeService.class, demande.getTypeDemande());
        this.mailer = factory.getStrategy(IMailer.class, demande.getTypeDemande());*/

    }

    /**
     * This method deals with the rebroadcasting and allows the writing of the marc transformed noticeBibio data from sudoc into STAR.Document table
     * @param
     * @return
     * @throws
     */
    @Override
    public void write(List<? extends NoticeBiblio> list) throws Exception {

        log.info("dans le write = ok");
    }

    /**
     * This method allows the writing of the rebroadcasting process result into STAR.TraitementNoticeBib table database
     * @param
     * @return
     * @throws
     */
    public void write2(List<? extends NoticeBiblio> list) throws Exception {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}
