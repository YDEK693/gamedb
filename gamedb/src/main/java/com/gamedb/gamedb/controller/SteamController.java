package com.gamedb.gamedb.controller;

import com.gamedb.gamedb.business.SteamBusiness;
import com.gamedb.gamedb.dto.GameDto;
import com.gamedb.gamedb.entity.SteamEntity;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.stereotype.Controller;


@Controller
@Path("/steam")
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


}
