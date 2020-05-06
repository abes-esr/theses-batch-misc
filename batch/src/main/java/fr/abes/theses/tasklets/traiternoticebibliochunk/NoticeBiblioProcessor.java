package fr.abes.theses.tasklets.traiternoticebibliochunk;

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

@Slf4j
@Component
public class NoticeBiblioProcessor implements ItemProcessor<NoticeBiblioDto, NoticeBiblioDto>, StepExecutionListener {
    @Value("${star.xsl}")
    private String cheminXslTef2Marc;

    @Value("${star.xsl.tef2marc}")
    private String fichierXslTef2Marc;

    @Autowired
    @Getter
    ServiceProvider service;

    private Integer jobId;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        jobId = stepExecution.getJobExecutionId().intValue();
    }

    /**
     * This method allows the conversion from marcxml Star tef format (Star.Document) to marc sudoc database format
     *
     * @param
     * @return
     * @throws
     */
    @Override
    public NoticeBiblioDto process(NoticeBiblioDto noticeBiblioDto) {
        try {
            Document doc = getService().getDocumentService().findById(noticeBiblioDto.getIddoc());
            log.info("chunk processor for iddoc : " + noticeBiblioDto.getIddoc());
            if (doc == null) {
                noticeBiblioDto.setRetourSudoc("These not found");
            } else {
                String marcXml = Utilitaire.getMarcXmlFromTef(doc, cheminXslTef2Marc, fichierXslTef2Marc);
                NoticeBiblioDto resultatInfoXml = getService().getMajStarSudocService().majStarSudocBiblio(marcXml, noticeBiblioDto);
                noticeBiblioDto.setRetourSudoc(resultatInfoXml.getRetourSudoc());
            }
        } catch (Exception e) {
            noticeBiblioDto.setRetourSudoc("Processor " + e.getMessage());
            noticeBiblioDto.setIndicSudoc("KO");
        }

        log.info("JobId " + jobId + " iddoc " + noticeBiblioDto.getIddoc() +" Processor " + noticeBiblioDto.getRetourSudoc());
        return noticeBiblioDto;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}



