package br.com.gustavo.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.gustavo.dto.LogDTO;
import br.com.gustavo.producer.LogProducer;

@Path("/logs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LogResource {
    private final Logger LOG = LoggerFactory.getLogger(LogResource.class);

    @Inject
    private LogProducer logProducer;

    @POST
    public Response send(LogDTO log) {
        LOG.info("Evento de LOG recebido");
        logProducer.sendLog(log);
        return Response.accepted().build();
    }
}
