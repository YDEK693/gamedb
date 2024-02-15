package com.gamedb.gamedb.repository.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GogClientInterceptor implements RequestInterceptor {
    String bearer = "jEaR-gndiirww_w5FDN2LOZzOmWHYTUoYuJa5WXYu5ExflPlmbBKQYQYnMOQe2LBTto1zpE8HprFx7e0vd4kmW8TR49YgO4PjmlJ6UXLI6M9cHYvoElh2Ok9C5YKFajAQiRQ4nF6qyv2a-AL2XoZ2f4RzTVOBbH2K9v8CApxlg1H7b0YunVK6RAopHVSONFT";
    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization","Bearer "+bearer);
        log.info("###################1 2 3 going to weather api");
    }
}
