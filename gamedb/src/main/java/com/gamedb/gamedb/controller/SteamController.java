package com.gamedb.gamedb.controller;

import com.gamedb.gamedb.business.SteamBusiness;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

@Controller
@Path("/steam")
public class SteamController {
    @Inject()
    private SteamBusiness steamBusiness;
    @Path("/mygame")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response games(){
        return Response.ok(steamBusiness.getGames()).build();
    }

}
