package com.gamedb.gamedb.Configuration;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api/v1")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
       /* packages("com.meunierubo.weather.controller");
        packages("com.meunierubo.weather.filter");
        packages("com.meunierubo.weather.exception");*/
    }

}
