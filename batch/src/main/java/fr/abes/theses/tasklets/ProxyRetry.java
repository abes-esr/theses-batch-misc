package fr.abes.theses.tasklets;

import fr.abes.cbs.exception.CBSException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProxyRetry {
    /*@Autowired
    @Getter
    private ServiceProvider service;*/

    /**
     * permet de retenter plusieurs fois la connexion à CBS
     * @throws CBSException
     */
    @Retryable
    public void authenticate() throws CBSException {
        log.info("dans authenticate du ProxyRetry avec login M4001");
/*
        getService().getMajStarSudocService().authenticateBiblio();
*/
    }
}
