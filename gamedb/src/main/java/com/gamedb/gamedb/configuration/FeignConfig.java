package com.gamedb.gamedb.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamedb.gamedb.repository.client.GogClient;
import com.gamedb.gamedb.repository.client.SteamClient;
import com.gamedb.gamedb.repository.interceptor.GogClientInterceptor;
import com.gamedb.gamedb.repository.interceptor.SteamClientInterceptor;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import jakarta.inject.Inject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Inject
    private GogClientInterceptor gogClientInterceptor;
    @Inject
    private SteamClientInterceptor steamClientInterceptor;
    @Inject
    private ObjectMapper objectMapper;
    @Bean
    SteamClient getSteamClient(){
        return Feign.builder()
                .requestInterceptor(steamClientInterceptor)
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .client(new OkHttpClient())
                .logger(new Logger.JavaLogger(FeignConfig.class))
                .logLevel(Logger.Level.FULL)
                .target(SteamClient.class,"https://api.steampowered.com/");
    }

    @Bean
    GogClient getGogClient(){
        return Feign.builder()
                .requestInterceptor(gogClientInterceptor)
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .client(new OkHttpClient())
                .logger(new Logger.JavaLogger(FeignConfig.class))
                .logLevel(Logger.Level.FULL)
                .target(GogClient.class,"https://embed.gog.com/");
    }

    private okhttp3.OkHttpClient getOkhttpClient(){
        var okHttpClient = new okhttp3.OkHttpClient().newBuilder();
        return okHttpClient.build();
    }
}