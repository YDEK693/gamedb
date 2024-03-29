package com.gamedb.gamedb.controller;

import com.gamedb.gamedb.business.AccountBusiness;
import com.gamedb.gamedb.dto.LoginInfo;
import com.gamedb.gamedb.entity.TokenEntity;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@Path("/login")
public class AuthenticationController {
    @Inject
    private AccountBusiness accountBusiness;
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticateByLogin(LoginInfo login) {
        TokenEntity token = accountBusiness.Authenticate(login.getMail(), login.getPassword());
        if(token != null) {
            return Response.ok("{\"token\" : \""+token.getToken()+"\"}").build();
        } else {
            return Response.status(403).build();
        }
    }
}
