package br.com.gustavo.service;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.gustavo.dto.LogDTO;
import br.com.gustavo.entity.LogEntity;

@ApplicationScoped
public class LogService {

    private final Logger LOG = LoggerFactory.getLogger(LogService.class);
    
    public void save(LogDTO log) {
        LogEntity logEntity = new LogEntity();
        logEntity.setDhOperacao(log.getDhOperacao());
        logEntity.setPontoVenda(log.getPontoVenda());
        logEntity.setPrograma(log.getPrograma());
        logEntity.setSistema(log.getSistema());
        logEntity.setPontoVenda(log.getPontoVenda());
        logEntity.setTipoOperacao(log.getTipoOperacao());
        logEntity.persist();

        LOG.info("Evento de LOG gravado no banco de dados");
    }
}
