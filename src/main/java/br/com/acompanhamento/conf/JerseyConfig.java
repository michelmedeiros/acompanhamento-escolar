package br.com.acompanhamento.conf;

import br.com.acompanhamento.gateways.http.JerseyController;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.stereotype.Component;

/**
 * Created by Michel Medeiros on 13/03/2017.
 */
@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        registerEndpoints();
        configureSwagger();
    }

    private void configureSwagger() {
        register(ApiListingResource.class);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/");
        beanConfig.setResourcePackage("br.com.acompanhamento.gateways.http");
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan(true);
    }
    private void registerEndpoints() {
        register(WadlResource.class);
        register(JerseyController.class);
    }
}
