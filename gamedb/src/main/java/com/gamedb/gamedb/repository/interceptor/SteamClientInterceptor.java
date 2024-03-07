package com.gamedb.gamedb.repository.interceptor;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SteamClientInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        log.info(template.headers().toString());

        log.info("###################steam");
        // log.info(template.headers().get("Authorization").toString());
    }


}

