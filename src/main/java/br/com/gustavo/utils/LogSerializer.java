package br.com.gustavo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gustavo.dto.LogDTO;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class LogSerializer implements Serializer<LogDTO> {
    
    private final Logger LOG = LoggerFactory.getLogger(LogSerializer.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, LogDTO log) {
        try {
            if (log == null){
                LOG.error("Null received at serializing");
                return new byte[0];
            }
            LOG.info("Serializing...");
            return objectMapper.writeValueAsBytes(log);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing log");
        }
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
