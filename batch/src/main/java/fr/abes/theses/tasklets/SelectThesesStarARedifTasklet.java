package fr.abes.theses.tasklets;

import fr.abes.theses.dao.INoticeBiblioDao;
import fr.abes.theses.dao.impl.DaoProvider;
import fr.abes.theses.model.entities.NoticeBiblio;
import fr.abes.theses.service.INoticeBiblioService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


@Slf4j
public class SelectThesesStarARedifTasklet implements Tasklet, StepExecutionListener {

    //IMailer mailer; on verra
    @Resource
    private INoticeBiblioService noticeBiblioService;

    @Resource
    private DaoProvider daoProvider;

    @Value("${solr.url}")
    private String urlSolr;

    private final String urlDiffusionTotale = "/solr1/select/?q=SGindicCines:OK+SGetabProd:oui&fl=id,SGetatWF,SGcodeEtab&sort=id%20asc&rows=5&wt=json";
    @Override
    public void beforeStep(StepExecution stepExecution) {

        log.info("entree dans beforeStep de SelectThesesStarARedifTasklet");
        ExecutionContext executionContext = stepExecution
                .getJobExecution()
                .getExecutionContext();

    }
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("Entrée dans SelectThesesStarARedif");

        try
        {
            String requete = urlSolr + urlDiffusionTotale;
            URL url = new URL(requete);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            String ligne = "";
            StringBuilder builder = new StringBuilder();
            while ((ligne = reader.readLine()) != null)
            {
                builder.append(ligne);
            }
            JSONObject json = new JSONObject(builder.toString());
            JSONArray docs = json.optJSONObject("response").optJSONArray("docs");

            if (docs.isEmpty())
            {
                log.info("Aucune notice à rediffuser");
                stepContribution.setExitStatus(new ExitStatus("AUCUNE NOTICE"));
            }
            else
            {
                log.info("Notices à rediffuser : " + docs.toString());
                for (int i=0;i<docs.length();i++)
                {
                    int iddoc = Integer.parseInt(docs.optJSONObject(i).optString("id"));
                    log.info("traite" + iddoc);
                    String codeEtab = docs.optJSONObject(i).optString("SGcodeEtab");
                    noticeBiblioService.save(new NoticeBiblio(iddoc, codeEtab, 0, ""));
                }
                stepContribution.setExitStatus(new ExitStatus("COMPLETED"));
            }
        }
        catch (Exception e) {
            log.error(e.toString());
//            mailer.mailEchecTraitement(
//                    this.email,
//                    this.demande.getId()
//            );
            stepContribution.setExitStatus(ExitStatus.FAILED);
        }
        return RepeatStatus.FINISHED;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return stepExecution.getExitStatus();
    }



}
