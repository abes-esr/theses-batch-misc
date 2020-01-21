package fr.abes.theses.tasklets;

import fr.abes.cbs.exception.CBSException;
import fr.abes.theses.model.dto.NoticeBiblioDto;
import fr.abes.theses.model.entities.Document;
import fr.abes.theses.service.ServiceProvider;
import fr.abes.theses.utils.Utilitaire;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
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

    @Value("${sudoc.passwd}")
    private String passwd;

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
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        String previousRcr = "";
        for (NoticeBiblioDto noticeBiblio : noticeBiblios) {
            if (noticeBiblio.getCodeEtab() != previousRcr) {
                authenticate("M" + noticeBiblio.getCodeEtab(), passwd, noticeBiblio);
                previousRcr = noticeBiblio.getCodeEtab();
            }
            Document doc = getService().getDocumentService().findById(noticeBiblio.getIddoc());
            if (doc == null) {
                noticeBiblio.setRetourSudoc("These not found");
            } else {
                String marcXml = Utilitaire.getMarcXmlFromTef(doc, cheminXslTef2Marc, fichierXslTef2Marc);
                NoticeBiblioDto resultatInfoXml = getService().getMajStarSudocService().majStarSudocExemp(marcXml, noticeBiblio);
                noticeBiblio.setRetourSudoc(resultatInfoXml.getRetourSudoc());
            }
        }
        return RepeatStatus.FINISHED;
    }

    private void authenticate(String login, String passwd, NoticeBiblioDto noticeBiblio) {
        try {
            getService().getMajStarSudocService().authenticateExemp(login, passwd);
        } catch (CBSException ex) {
            noticeBiblio.setRetourSudoc(ex.getMessage());
        }
    }
}
