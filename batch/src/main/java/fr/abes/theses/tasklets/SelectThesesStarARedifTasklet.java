package fr.abes.theses.tasklets;

import fr.abes.cbs.exception.CBSException;
import fr.abes.theses.service.ServiceProvider;
import fr.abes.theses.thesesAccessLayer.model.entities.star.NoticeBiblio;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


@Slf4j
public class SelectThesesStarARedifTasklet implements Tasklet, StepExecutionListener {
    @Autowired @Getter
    ServiceProvider service;

    private Integer jobId;
    private String jobName;
    
    @Value("${rowsNumber}")
    private Integer rowsNumber;

    @Value("${startRow}")
    private Integer startRow;

    @Value("${solr.url}")
    private String urlSolr;

    @Value("${idThese}")
    private String idThese;

    @Value("${sudoc.loginM4001}")
    private String login;

    @Value("${sudoc.passwdM4001}")
    private String passwd;

    private final String urlDiffusionTotale = "/solr1/select/?q=SGindicCines:OK+SGetabProd:oui&fl=id,SGetatWF,SGcodeEtab&sort=SGcodeEtab%20asc&wt=json";
    private final String urlDiffusionExemp = "/solr1/select/?q=SGindicCines:OK+SGetabProd:oui+SGRCRSudoc:[''%20TO%20*]&fl=SGRCRSudoc,id&sort=id%20asc&wt=json";
    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("entree dans beforeStep de SelectThesesStarARedifTasklet");
        jobId = stepExecution.getJobExecutionId().intValue();
        log.info("Lancement Job n° " + jobId);
        jobName = stepExecution.getJobExecution().getJobInstance().getJobName();
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("Entrée dans SelectThesesStarARedif");

        try
        {
            String requete;
            if (jobName.equals("diffuserThesesVersSudoc")) {
                requete = urlSolr + urlDiffusionTotale;
            } else {
                requete = urlSolr + urlDiffusionExemp;
            }
            requete += "&start=" + startRow + "&rows=" + rowsNumber;

            if (!idThese.equals("null"))
            {
                requete = getRequeteParIdThese();
            }

            JSONArray docs = getJson(requete);

            if (docs.isEmpty())
            {
                log.info("Aucune notice à rediffuser");
                stepContribution.setExitStatus(new ExitStatus("AUCUNE NOTICE"));
            }
            else
            {
                log.info("Notices à rediffuser : " + docs.toString());
                if (jobName.equals("diffuserThesesVersSudoc")) {
                    extractJsonBiblio(docs);
                } else {
                    extractJsonExemp(docs);
                }
                stepContribution.setExitStatus(new ExitStatus("COMPLETED"));
            }
        }
        catch (Exception e) {
            log.error(e.getMessage());
            stepContribution.setExitStatus(ExitStatus.FAILED);
        }
        return RepeatStatus.FINISHED;
    }

    private String getRequeteParIdThese() {
        String requete;
        if(jobName.equals("diffuserThesesVersSudoc")){
            requete = urlSolr + "/solr1/select/?" +
                    "q=SGindicCines:OK+SGetabProd:oui" + "+id:" + idThese +
                    "&fl=id,SGetatWF,SGcodeEtab" +
                    "&sort=id%20asc" +
                    "&wt=json";
        } else {
            requete = urlSolr +"/solr1/select/?" +
                    "q=SGindicCines:OK+SGetabProd:oui+SGRCRSudoc:[''%20TO%20*]" + "+id:" + idThese +
                    "&fl=SGRCRSudoc,id" +
                    "&wt=json";
        }
        return requete;
    }

    private void extractJsonExemp(JSONArray docs) {
        try {
            getService().getMajStarSudocService().authenticateBiblio(login, passwd);
            for (int i = 0; i < docs.length(); i++) {
                int iddoc = Integer.parseInt(docs.optJSONObject(i).optString("id"));
                for (int j = 0; j < docs.optJSONObject(i).optJSONArray("SGRCRSudoc").length(); j++) {
                    String rcr = docs.optJSONObject(i).optJSONArray("SGRCRSudoc").getString(j);
                    log.info("rcr n° "+ rcr);
                    //si le rcr appartient un ILN d'établissement non déployé, on se connectera avec un login de rcr spécifique pour l'exemplarisation
                    try {
                        if (Integer.parseInt(getService().getMajStarSudocService().getClientBiblio().ilnRattachement(rcr)) > 199
                                && Integer.parseInt(getService().getMajStarSudocService().getClientBiblio().ilnRattachement(rcr)) <= 300)
                            rcr = "341720008";
                    } catch (NumberFormatException e){
                        log.warn("Impossible de verrifier l'ILN de rattachement pour le rcr :" + rcr);
                    }
                    getService().getNoticeBiblioService().save(new NoticeBiblio(jobId, iddoc, rcr, 0, "", null, null, null, null, null));
                }
            }
            getService().getMajStarSudocService().disconnectBiblio();
        }catch (CBSException ex) {
            log.error("Impossible de se connecter au cbs " + ex.getMessage());
        }
    }

    private void extractJsonBiblio(JSONArray docs) {
        for (int i=0;i<docs.length();i++)
        {
            int iddoc = Integer.parseInt(docs.optJSONObject(i).optString("id"));
            log.info("traite : " + iddoc);
            String codeEtab = docs.optJSONObject(i).optString("SGcodeEtab");
            getService().getNoticeBiblioService().save(new NoticeBiblio(jobId, iddoc, codeEtab, 0, "", null, null, null, null, null));
        }
    }

    private JSONArray getJson(String requete) throws IOException {
        URL url = new URL(requete);
        JSONObject json;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
            String ligne = "";
            StringBuilder builder = new StringBuilder();
            while ((ligne = reader.readLine()) != null) {
                builder.append(ligne);
            }
            json = new JSONObject(builder.toString());
        }
        return json.optJSONObject("response").optJSONArray("docs");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return stepExecution.getExitStatus();
    }



}
