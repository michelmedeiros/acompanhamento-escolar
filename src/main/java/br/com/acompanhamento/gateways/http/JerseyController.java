package br.com.acompanhamento.gateways.http;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class JerseyController {
    @GET
    public String helloWorld() {
        return "Hello world!";
    }
}
