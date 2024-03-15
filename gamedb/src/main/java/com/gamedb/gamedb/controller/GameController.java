package com.gamedb.gamedb.controller;

import com.gamedb.gamedb.business.AccountBusiness;
import com.gamedb.gamedb.business.GogBusiness;
import com.gamedb.gamedb.business.SteamBusiness;
import com.gamedb.gamedb.dto.GameDto;
import com.gamedb.gamedb.entity.*;
import com.gamedb.gamedb.filter.AuthenticationRequired;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.ArrayList;
import java.util.List;

import static com.gamedb.gamedb.mapper.GameMapper.*;

@Controller
@Path("/games")
public class GameController {
    @Inject()
    private SteamBusiness steamBusiness;
    @Inject()
    private GogBusiness gogBusiness;
    @Inject
    private AccountBusiness accountBusiness;
    @GET
    public Response getGames() {
        String list = "[" +
                "{ 'name' : 'vampire survivors'}," +
                "{ 'name' : 'dwarf fortress'},";
        return Response.ok(list).build();
    }

    @Path("/steam/computer")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @AuthenticationRequired
    public Response steamGamesComputer(@HeaderParam("Authentication") String tokenApp, @QueryParam("steamId") String steamId){
        if(steamId == null) {

            AccountEntity account =  accountBusiness.getAccountByToken(tokenApp);
            AccountSettingsEntity setting = accountBusiness.getAccountSettings(account.getId());
            steamId = setting.getSteamUser();
        }

        List<SteamEntity> entityGames = steamBusiness.getGames(steamId);
        List<GameDto> dtoGames = new ArrayList<>();
        for(SteamEntity game : entityGames){
            dtoGames.add(SteamEntityToGameDtoComputer(game));
        }

        return Response.ok(dtoGames).build();
    }

    @Path("/steam/mobile")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @AuthenticationRequired
    public Response steamGamesMobile(@HeaderParam("Authentication") String tokenApp, @QueryParam("steamId") String steamId){
        if(steamId == null) {
            AccountEntity account =  accountBusiness.getAccountByToken(tokenApp);
            AccountSettingsEntity setting = accountBusiness.getAccountSettings(account.getId());
            steamId = setting.getSteamUser();
        }

        List<SteamEntity> entityGames = steamBusiness.getGames(steamId);
        List<GameDto> dtoGames = new ArrayList<>();
        for(SteamEntity game : entityGames){
            dtoGames.add(SteamEntityToGameDtoMobile(game));
        }

        return Response.ok(dtoGames).build();
    }

    @Path("/gog/mobile")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response gogGamesMobile(@HeaderParam("Authorization") String authorizationHeader){
        List<GogEntity> entityGames = gogBusiness.getGamesMobile(authorizationHeader);
        List<GameDto> dtoGames = new ArrayList<>();
        for(GogEntity game : entityGames){
            dtoGames.add(GogEntityToGameDtoMobile(game));
        }

        return Response.ok(dtoGames).build();
    }

    @Path("/gog/computer")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response gogGamesComputer(@HeaderParam("Authorization") String authorizationHeader){
        List<GogEntity> entityGames = gogBusiness.getGamesComputer(authorizationHeader);
        List<GameDto> dtoGames = new ArrayList<>();
        for(GogEntity game : entityGames){
            dtoGames.add(GogEntityToGameDtoComputer(game));
        }

        return Response.ok(dtoGames).build();
    }
}
