package fr.abes.theses.tasklets.exemplairechunk;

import fr.abes.theses.model.dto.NoticeBiblioDto;
import fr.abes.theses.model.entities.Document;
import fr.abes.theses.service.ServiceProvider;
import fr.abes.theses.utils.Utilitaire;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class ExemplaireProcessor implements ItemProcessor<NoticeBiblioDto, NoticeBiblioDto>, StepExecutionListener {

    @Value("${star.xsl}")
    private String cheminXslTef2Marc;

    @Value("${star.xsl.tef2marc}")
    private String fichierXslTef2Marc;

    @Value("${sudoc.passwdM4001}")
    private String passwd;

    @Autowired
    @Getter
    ServiceProvider service;

    private Integer jobId;

    @Override
    public NoticeBiblioDto process(NoticeBiblioDto noticeBiblio) throws Exception {

        log.info("Id de notice : " + noticeBiblio.getId().toString());
        log.info("RCR n° " + noticeBiblio.getCodeEtab());

        try {
            getService().getMajStarSudocService().authenticateExemp("M" + noticeBiblio.getCodeEtab(), passwd);

            Document doc = getService().getDocumentService().findById(noticeBiblio.getIddoc());
            boolean premiereExemplarisationRcrNonDeploye = getService().getMajStarSudocService().getPremiereExemplarisationRcrNonDeploye();
            if (doc == null) {
                noticeBiblio.setRetourSudoc("These not found");
            } else {
                String marcXml = Utilitaire.getMarcXmlFromTef(doc, cheminXslTef2Marc, fichierXslTef2Marc);
                NoticeBiblioDto resultatInfoXml = getService().
                        getMajStarSudocService().
                        majStarSudocExemp(marcXml, noticeBiblio, premiereExemplarisationRcrNonDeploye);
                noticeBiblio.setRetourSudoc(resultatInfoXml.getRetourSudoc());
            }
            noticeBiblio.setDone(1);
            noticeBiblio.setDateModification(new Date());

            if (noticeBiblio.getCodeEtab().equals("341720008")) {
                getService().getMajStarSudocService().setPremiereExemplarisationRcrNonDeploye(false);
            }

        } catch (Exception e) {
            noticeBiblio.setRetourSudoc(noticeBiblio.getRetourSudoc() + " : " + e.getMessage());
            noticeBiblio.setIndicSudoc("KO");
        }

        log.info("JobId " + jobId + " iddoc " + noticeBiblio.getIddoc() +" Processor " + noticeBiblio.getRetourSudoc());

        return noticeBiblio;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        jobId = stepExecution.getJobExecutionId().intValue();
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}
