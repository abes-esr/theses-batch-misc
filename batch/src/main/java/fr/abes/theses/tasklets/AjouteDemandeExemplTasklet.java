package fr.abes.theses.tasklets;

import fr.abes.theses.model.entities.DocumentEnvoiSudoc;
import fr.abes.theses.service.ServiceProvider;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class AjouteDemandeExemplTasklet implements Tasklet {

    @Autowired
    @Getter
    ServiceProvider service;

    @Value("${batch_bdd}")
    private boolean batchBdd;

    @PersistenceContext
    private EntityManager em;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        if (batchBdd) {
            log.info("Ajout des demandes d'exemplaires dans la table documentEnvoiSudoc");

            List<Integer> ids = (List<Integer>) chunkContext.getStepContext()
                    .getStepExecution()
                    .getJobExecution()
                    .getExecutionContext()
                    .get("ids_biblio");

            StringBuilder sb = new StringBuilder("INSERT INTO document_envoi_sudoc (iddoc, niveau) ");
            sb.append("SELECT column_value, 'exempl' FROM TABLE(sys.odcinumberlist(");
            sb.append(ids.stream().map(String::valueOf).collect(Collectors.joining(",")));
            sb.append("))");

            em.createNativeQuery(sb.toString()).executeUpdate();

        } else {
            log.info("Pas d'ajout dans la bdd car batchBdd = false");
        }

        return RepeatStatus.FINISHED;
    }
}
