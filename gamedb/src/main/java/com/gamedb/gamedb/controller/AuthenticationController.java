package com.gamedb.gamedb.controller;

import com.gamedb.gamedb.business.AccountBusiness;
import com.gamedb.gamedb.dto.LoginInfo;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@Path("/login")
@CrossOrigin
public class AuthenticationController {
    @Inject
    private AccountBusiness accountBusiness;
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticate(LoginInfo login) {
        if(accountBusiness.Authenticate(login.getMail(), login.getPassword())){
            return Response.ok("{\ntoken : "+login.getPassword()+login.getMail()+"\n}").build();
        } else {
            return Response.status(403).build();
        }
    }
}
