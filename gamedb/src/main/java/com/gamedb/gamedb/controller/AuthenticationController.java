package com.gamedb.gamedb.controller;

import com.gamedb.gamedb.business.AccountBusiness;
import com.gamedb.gamedb.dto.LoginInfo;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

@Controller
@Path("/login")
public class AuthenticationController {
    @Inject
    private AccountBusiness accountBusiness;
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticate(LoginInfo login) {
        if(accountBusiness.Authenticate(login.getMail(), login.getPassword())){
            return Response.ok().build();
        } else {
            return Response.status(403).build();
        }
    }
}
