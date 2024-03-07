package com.gamedb.gamedb.repository.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GogClientInterceptor implements RequestInterceptor {
    String bearer = "SA30dhXZL-A5Kn9BSrxM5T-tYLxOHS6TgT_hW8bSNmwKdut9B4VxqfnNWoDnH8xUVN_bJBQL1tGEw59pto1iO-tJggyZTc9EfmbT5yvoqiR0mX6a4MJjnJk2nRcG_Qom7ESGLzeqexlzqDcYwnbGJ8OTeAkJyp-Ji2n0g6KL-S3EwSCF-1ukqCCqRom7o-Ta";
    @Override
    public void apply(RequestTemplate template) {
        log.info(template.headers().toString());
     
        log.info("###################1 2 3 gog");
       // log.info(template.headers().get("Authorization").toString());
    }
}
