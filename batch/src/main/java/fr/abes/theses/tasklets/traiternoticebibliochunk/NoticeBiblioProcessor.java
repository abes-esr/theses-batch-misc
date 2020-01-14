package fr.abes.theses.tasklets.traiternoticebibliochunk;

import fr.abes.theses.model.entities.NoticeBiblio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NoticeBiblioProcessor implements ItemProcessor<NoticeBiblio, NoticeBiblio>, StepExecutionListener {

   /* @Autowired
    StrategyFactory factory;

    @Autowired
    ProxyRetry proxyRetry;
    @Autowired
    @Getter
    ServiceProvider service;*/

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
    public NoticeBiblio process(NoticeBiblio noticeBiblio) throws Exception {

        log.info("dans le process = " + noticeBiblio);
        return noticeBiblio;
    }


    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}



