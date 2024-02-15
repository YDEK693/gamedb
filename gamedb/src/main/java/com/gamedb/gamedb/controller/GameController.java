package com.gamedb.gamedb.controller;

import com.gamedb.gamedb.business.SteamBusiness;
import com.gamedb.gamedb.dto.GameDto;
import com.gamedb.gamedb.entity.SteamEntity;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import static com.gamedb.gamedb.mapper.GameMapper.SteamEntityToGameDto;

@Controller
@Path("/games")
public class GameController {
    @Inject()
    private SteamBusiness steamBusiness;
    @GET
    public Response getGames() {
        String list = "[" +
                "{ 'name' : 'vampire survivors'}," +
                "{ 'name' : 'dwarf fortress'},";
        return Response.ok(list).build();
    }

    @Path("/steam")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response steamGames(){
        List<SteamEntity> entityGames = steamBusiness.getGamesTest();
        List<GameDto> dtoGames = new ArrayList<>();
        for(SteamEntity game : entityGames){
            dtoGames.add(SteamEntityToGameDto(game));
        }

        return Response.ok(dtoGames).build();
    }

    @Path("/gog")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response gogGames(){
        List<SteamEntity> entityGames = steamBusiness.getGamesTest();
        List<GameDto> dtoGames = new ArrayList<>();
        for(SteamEntity game : entityGames){
            dtoGames.add(SteamEntityToGameDto(game));
        }

        return Response.ok(dtoGames).build();
    }
}
