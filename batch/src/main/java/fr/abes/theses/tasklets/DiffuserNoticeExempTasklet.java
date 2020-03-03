package fr.abes.theses.tasklets;

import fr.abes.cbs.exception.CBSException;
import fr.abes.theses.model.dto.NoticeBiblioDto;
import fr.abes.theses.model.dto.NoticeBiblioDtoMapper;
import fr.abes.theses.model.entities.Document;
import fr.abes.theses.model.entities.NoticeBiblio;
import fr.abes.theses.service.ServiceProvider;
import fr.abes.theses.utils.Utilitaire;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.DocumentException;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.xml.transform.TransformerException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class DiffuserNoticeExempTasklet implements Tasklet, StepExecutionListener {
    @Value("${star.xsl}")
    private String cheminXslTef2Marc;

    @Value("${star.xsl.tef2marc}")
    private String fichierXslTef2Marc;

    @Autowired
    @Getter
    ServiceProvider service;

    Integer jobId;
    private List<NoticeBiblioDto> noticeBiblios;

    @Value("${sudoc.passwdM4001}")
    private String passwd;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public DiffuserNoticeExempTasklet() {
        this.noticeBiblios = new ArrayList<>();
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        this.noticeBiblios = (List<NoticeBiblioDto>) stepExecution
                .getJobExecution()
                .getExecutionContext().get("noticesBiblio");
        this.jobId = stepExecution.getJobExecutionId().intValue();
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        if (ExitStatus.COMPLETED.equals(stepExecution.getExitStatus())) {
            stepExecution.getJobExecution().getExecutionContext().put("noticesBiblio", this.noticeBiblios);
        }
        return stepExecution.getExitStatus();
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) {
        String previousRcr = "";
        boolean premiereExemplarisationRcrNonDeploye = true;

        log.info("Size noticeBib : " + noticeBiblios.size());

        for (NoticeBiblioDto noticeBiblio : noticeBiblios) {
            log.info("Id de notice : " + noticeBiblio.getId().toString());
            NoticeBiblio noticeBiblioEntity = new NoticeBiblio();
            try {
                if (!noticeBiblio.getCodeEtab().equals(previousRcr)) {
                    getService().getMajStarSudocService().disconnectExemp();
                    authenticate("M" + noticeBiblio.getCodeEtab(), passwd, noticeBiblio);
                    previousRcr = noticeBiblio.getCodeEtab();
                }
                Document doc = getService().getDocumentService().findById(noticeBiblio.getIddoc());
                if (doc == null) {
                    noticeBiblio.setRetourSudoc("These not found");

                } else {
                    String marcXml = Utilitaire.getMarcXmlFromTef(doc, cheminXslTef2Marc, fichierXslTef2Marc);
                    NoticeBiblioDto resultatInfoXml = getService().getMajStarSudocService().majStarSudocExemp(marcXml, noticeBiblio, premiereExemplarisationRcrNonDeploye);
                    noticeBiblio.setRetourSudoc(resultatInfoXml.getRetourSudoc());
                }
                noticeBiblio.setDone(1);
                noticeBiblio.setDateModification(new Date());
                noticeBiblioEntity = NoticeBiblioDtoMapper.getNoticeBiblioEntity(noticeBiblio);
                getService().getGestionTefService().majDonneesGestionExemplarisation(noticeBiblio);

                if (noticeBiblio.getCodeEtab().equals("341720008")){
                    premiereExemplarisationRcrNonDeploye = false;
                }

            } catch (Exception e){
                noticeBiblioEntity.setRetourSudoc(noticeBiblioEntity.getRetourSudoc() + " : " + e.getMessage());
            }
            updateNoticeBiblio(noticeBiblioEntity);
        }
        disconnect();
        return RepeatStatus.FINISHED;
    }

    public void updateNoticeBiblio(NoticeBiblio noticeBiblioEntity) {
        jdbcTemplate.update("UPDATE STAR.T_E_TRAITEMENT_NOTICEBIB_TNB SET " +
                "TRAITEE = ?, " +
                "RETOUR_SUDOC = ?, " +
                "PPN = ?, " +
                "DATE_MODIFICATION = ? "+
                "WHERE ID = ?",
                noticeBiblioEntity.getDone(),
                noticeBiblioEntity.getRetourSudoc(),
                noticeBiblioEntity.getEpn(),
                noticeBiblioEntity.getDateModification(),
                noticeBiblioEntity.getId());
        jdbcTemplate.update("commit");
    }

    private void authenticate(String login, String passwd, NoticeBiblioDto noticeBiblio) {
        try {
            getService().getMajStarSudocService().authenticateExemp(login, passwd);
        } catch (CBSException ex) {
            noticeBiblio.setRetourSudoc(ex.getMessage());
        }
    }

    private void disconnect() {
        getService().getMajStarSudocService().disconnectExemp();
    }
}
