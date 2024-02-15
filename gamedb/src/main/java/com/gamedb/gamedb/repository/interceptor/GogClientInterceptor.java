package com.gamedb.gamedb.repository.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GogClientInterceptor implements RequestInterceptor {
    String bearer = "Bearer mOpIGGHmK3u5dDElWw-4VEaE9zCeEQInyxnWIOMrtreVeRoqPBe6bbedGyJfb9H1pnI8a8HUndD0IotxmLNrq_x5KUsw6o-nZgbuUpLZ390umDnQEtUOZ1twlNbhIx5iRUh-5zJNERgr1guBnj_LAjAsxRd1LuU-pT54di7_aZrNEkUZtonIqbLITLE8gxbN";
    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization ","Bearer mOpIGGHmK3u5dDElWw-4VEaE9zCeEQInyxnWIOMrtreVeRoqPBe6bbedGyJfb9H1pnI8a8HUndD0IotxmLNrq_x5KUsw6o-nZgbuUpLZ390umDnQEtUOZ1twlNbhIx5iRUh-5zJNERgr1guBnj_LAjAsxRd1LuU-pT54di7_aZrNEkUZtonIqbLITLE8gxbN");
        log.info("###################1 2 3 going to weather api");
    }
}
