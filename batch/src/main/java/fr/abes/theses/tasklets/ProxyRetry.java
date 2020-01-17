package fr.abes.theses.tasklets;

import fr.abes.cbs.exception.CBSException;
import fr.abes.theses.service.ServiceProvider;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProxyRetry {
    @Autowired
    @Getter
    private ServiceProvider service;

    /**
     * permet de retenter plusieurs fois la connexion à CBS
     * @throws CBSException
     */
    @Retryable
    public void authenticate(String login, String passwd) throws CBSException {
        log.info("dans authenticate du ProxyRetry avec login M4001");

        getService().getMajStarSudocService().authenticate(login, passwd);
    }
}
