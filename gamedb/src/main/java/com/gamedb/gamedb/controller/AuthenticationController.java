package com.gamedb.gamedb.controller;

import com.gamedb.gamedb.business.AccountBusiness;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

@Controller
@Path("/login")
public class AuthenticationController {
    @Inject
    private AccountBusiness accountBusiness;
    @GET
    public Response authenticate() {
        if(accountBusiness.Authenticate()){
            return Response.ok().build();
        } else {
            return Response.status(403).build();
        }
    }
}
