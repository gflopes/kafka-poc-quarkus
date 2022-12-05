package br.com.gustavo.consumer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.gustavo.dto.LogDTO;
import br.com.gustavo.service.LogService;
import io.smallrye.reactive.messaging.kafka.Record;

@ApplicationScoped
public class LogConsumer {
    private final Logger LOG = LoggerFactory.getLogger(LogConsumer.class);

    @Inject
    private LogService service;

    @Incoming("sicli-in")
    @Transactional
    public void addLog(Record<String, LogDTO> logRecord) {
        LOG.info("Nova trilha de log {} - {} - {} consumida", 
            logRecord.value().getDhOperacao(), 
            logRecord.value().getTipoOperacao(), 
            logRecord.value().getSistema());

        service.save(logRecord.value());
    }
}
