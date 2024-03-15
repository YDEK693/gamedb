package com.gamedb.gamedb.filter;

import com.gamedb.gamedb.repository.AccountRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;
import java.util.List;

@AuthenticationRequired
@Provider
public class AuthenticationRequiredFilter implements ContainerRequestFilter {
     @Inject
     AccountRepository accountRepository;
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        List<String> token = requestContext.getHeaders().get("Authentication");
        if(token==null || token.isEmpty() ||this.accountRepository.getIdByToken(token.get(0))==-1) {
            requestContext.abortWith(Response.status(403).build());
        }
    }
}
