package com.gamedb.gamedb.controller;

import com.gamedb.gamedb.business.SteamBusiness;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

@Controller
@Path("/games")
public class SteamController {
    @Inject()
    private SteamBusiness steamBusiness;
    @Path("/steam")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object games(){
        return steamBusiness.getGames();
    }

    @Path("/steam/test")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response gamesTest(){
        return Response.ok(steamBusiness.getGamesTest()).build();
    }

}
