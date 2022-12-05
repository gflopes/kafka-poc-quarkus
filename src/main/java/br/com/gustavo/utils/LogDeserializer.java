package br.com.gustavo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gustavo.dto.LogDTO;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class LogDeserializer implements Deserializer<LogDTO> {
    
    private final Logger LOG = LoggerFactory.getLogger(LogDeserializer.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public LogDTO deserialize(String s, byte[] data) {
        try {
            if (data == null){
                LOG.error("Null received at deserializing");
                return null;
            }
            LOG.info("Deserializing...");
            return objectMapper.readValue(new String(data, StandardCharsets.UTF_8), LogDTO.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to Log");
        }
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}