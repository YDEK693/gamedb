package com.gamedb.gamedb.repository.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GogClientInterceptor implements RequestInterceptor {
    String bearer = "FflPAhX3Xyh9BhGpN9aivNIWEVCvuHFG855MI3E4fC5Z804jQu11cTfcjwqS6GLGzbqSjaMKHUDs--v0hFKlhZadRPhJchhGCDoQfkeA2tpKYGEv0r6PN_cH-caeGQE-N8Gr6nhNkVt9vXkVpT9MroZejCQF7-6MflQgUpjuKDEOjR6-9JyD6LDwi2YdAfWs";
    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization","Bearer "+bearer);
        log.info("###################1 2 3 going to weather api");
    }
}
