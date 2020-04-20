package fr.abes.theses.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;

@Slf4j
public class DefaultListenerSupport extends RetryListenerSupport {

    @Override
    public <T, E extends Throwable> void onError(RetryContext context,
                                                 RetryCallback<T, E> callback, Throwable throwable) {

        log.info("onError");
        throwable.printStackTrace();

        super.onError(context, callback, throwable);
    }
}
