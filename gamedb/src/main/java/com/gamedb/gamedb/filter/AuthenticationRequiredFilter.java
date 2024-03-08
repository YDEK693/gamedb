package com.gamedb.gamedb.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@AuthenticationRequired
@Provider
public class AuthenticationRequiredFilter implements ContainerRequestFilter {
     @Inject
     AccountRepository accountRepository;
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String token = requestContext.getHeaders().get("Authentication");
        if(token==null || this.accountRepository.getIdByToken(token)==null) {
            requestContext.abortWith(Response.status(403).build());
        }
    }
}
