package br.com.gustavo.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import br.com.gustavo.dto.LogDTO;
import io.smallrye.reactive.messaging.kafka.Record;

@ApplicationScoped
public class LogProducer {

    private final Logger LOG = LoggerFactory.getLogger(LogProducer.class);

    @Inject
    @Channel("sicli-out")
    Emitter<io.smallrye.reactive.messaging.kafka.Record<String, LogDTO>> logEmitter;

    public void sendLog(final LogDTO log) {
        logEmitter.send(Record.of(log.getDhOperacao(), log));
        LOG.info("Evento de LOG consumido");
    }
}
