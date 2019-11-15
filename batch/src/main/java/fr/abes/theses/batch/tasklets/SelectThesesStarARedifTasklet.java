package fr.abes.theses.batch.tasklets;

import fr.abes.theses.core.dao.INoticeBiblioDao;
import fr.abes.theses.core.dao.ITraitementDao;
import fr.abes.theses.core.dao.impl.DaoProvider;
import fr.abes.theses.core.model.entities.NoticeBiblio;
import fr.abes.theses.core.service.ServiceProvider;
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
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


@Slf4j
public class SelectThesesStarARedifTasklet implements Tasklet, StepExecutionListener {

    //IMailer mailer; on verra
    @Autowired
    private INoticeBiblioDao noticeBiblio;

    @Autowired
    private DaoProvider daoProvider;

    @Value("${solr.url}")
    private String urlSolr;

    private final String urlDiffusionTotale = "/select/?q=SGcodeEtab:(USPC%20OR%20PA13%20OR%20LEMA%20OR%20EMAC%20OR%20ESAE%20OR%20MULH)+SGindicCines:OK+SGetabProd:oui&fl=id,SGetatWF,SGcodeEtab&sort=id%20asc&rows=5000&wt=json";
    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    /*@Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return stepExecution.getExitStatus();
    }*/


    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("Entrée dans SelectThesesStarARedif");

        try
        {
            String requete = urlSolr + urlDiffusionTotale;
            URL urlEmbargo = new URL(requete);
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlEmbargo.openStream(), "UTF-8"));
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
                    String codeEtab = docs.optJSONObject(i).optString("SGcodeEtab");
                    noticeBiblio.save(new NoticeBiblio(, iddoc, codeEtab, 0, ""));
                }
                stepContribution.setExitStatus(new ExitStatus("COMPLETED"));
            }
        }
        catch (Exception e) {
            log.error("Erreur lors de la récupération des iddoc, codeetab via solr = "
                    + e.toString());
            mailer.mailEchecTraitement(
                    this.email,
                    this.demande.getId()
            );
            stepContribution.setExitStatus(ExitStatus.FAILED);
        }
        return RepeatStatus.FINISHED;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        if (stepExecution.getJobExecution().getExitStatus().equals(ExitStatus.FAILED)) {
            return ExitStatus.FAILED;
        }
        return ExitStatus.COMPLETED;
    }



}
