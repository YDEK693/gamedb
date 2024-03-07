package com.gamedb.gamedb.configuration;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api/v1")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CorsFilter.class);
        packages("com.gamedb.gamedb.controller");
        packages("com.gamedb.gamedb.configuration");
       // packages("com.gamedb.gamedb.exception");
    }

}
