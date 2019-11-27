package fr.abes.theses.tasklets.traiternoticebibliochunk;

import fr.abes.cbs.exception.CBSException;
import fr.abes.theses.model.NoticeBiblioDto;
import fr.abes.theses.model.NoticeBiblioDtoMapper;
import fr.abes.theses.model.entities.Document;
import fr.abes.theses.model.entities.NoticeBiblio;
import fr.abes.theses.service.ServiceProvider;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

@Slf4j
@Component
public class NoticeBiblioProcessor implements ItemProcessor<NoticeBiblioDto, NoticeBiblioDto>, StepExecutionListener {

    @Value("${star.xsl}")
    private String cheminXslTef2Marc;

    @Value("${star.xsl.tef2marc}")
    private String fichierXslTef2Marc;

       /* @Autowired
    StrategyFactory factory;

    @Autowired
    ProxyRetry proxyRetry;*/
    @Autowired
    @Getter
   ServiceProvider service;

    private NoticeBiblio noticeBiblio;


    @Override
    public void beforeStep(StepExecution stepExecution) {
       /* ExecutionContext executionContext = stepExecution
                .getJobExecution()
                .getExecutionContext();
        this.noticeBiblio = (NoticeBiblio) executionContext.get("noticeBiblio");
        //log.info("...pour la noticeBiblio " + this.noticeBiblio.getId());*/
    }

    /**
     * This method allows the conversion from marcxml Star tef format (Star.Document) to marc sudoc database format
     *
     * @param
     * @return
     * @throws
     */

    @Override
    public NoticeBiblioDto process(NoticeBiblioDto noticeBiblioDto) throws Exception {

      /*  try {
            int iddoc = ligneFichierDto.getIddoc();

        } catch (CBSException e) {
            log.error("erreur lors de la requête au Sudoc ou du saveExemplaire" + e.toString());
            ligneFichierDto.setRetourSudoc(e.getMessage());
        } catch (Exception e) {
            log.error("erreur lors de la recup de la noticetraitee : " + e.toString());
            ligneFichierDto.setRetourSudoc(e.getMessage());
        }*/

      try {
          Document doc = getService().getDocumentService().findById(noticeBiblioDto.getId());

          String marcXml = getMarcXmlFromTef(doc);

          String resultatInfoXml = getService().getMajStarSudocService().majStarSudoc(marcXml);

          noticeBiblioDto.setRetourSudoc(resultatInfoXml);
      } catch (CBSException e)
      {
          noticeBiblioDto.setRetourSudoc(e.getMessage());
      }

        return noticeBiblioDto;
    }

    private String getMarcXmlFromTef(Document doc) throws TransformerException {

        try {
            Source stylesheet = new StreamSource(new File(cheminXslTef2Marc + fichierXslTef2Marc));
            StreamSource stream = new StreamSource(new StringReader(doc.getDoc()));
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(stylesheet);
            final StringWriter writer = new StringWriter();
            final StreamResult output = new StreamResult(writer);
            transformer.transform(stream, output);

            return writer.toString();

        }catch (TransformerException e){
            throw e;
        }
    }


    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}



