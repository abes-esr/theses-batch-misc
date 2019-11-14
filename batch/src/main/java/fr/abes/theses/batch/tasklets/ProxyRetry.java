package fr.abes.theses.batch.tasklets;

import fr.abes.cbs.exception.CBSException;
import fr.abes.theses.core.service.ServiceProvider;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class ProxyRetry {
    @Resource
    @Getter
    private ServiceProvider service;

    /**
     * permet de retenter plusieurs fois la connexion à CBS
     * @throws CBSException
     */
    @Retryable
    public void authenticate() throws CBSException {
        log.info("dans authenticate du ProxyRetry avec login M4001");
        getService().getMajStarSudoc().authenticateBiblio();
    }
}
