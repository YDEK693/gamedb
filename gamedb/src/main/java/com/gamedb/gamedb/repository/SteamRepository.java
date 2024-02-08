package com.gamedb.gamedb.repository;

import com.gamedb.gamedb.dto.Response;
import com.gamedb.gamedb.dto.SteamResponse;
import com.gamedb.gamedb.repository.client.SteamClient;
import jakarta.inject.Inject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class SteamRepository {
    @Inject
    private SteamClient steamClient;

    @Value("${spring.secrets.steam.key}")
    private String key;

    @Value("${spring.secrets.steam.steamid}")
    private String steamid;

    private String token;
    public Object getGames(){
        return  steamClient.getGame(key, steamid);
    }

    public Response getGamesTest(){
        return  steamClient.getGameTest(key, steamid);
    }

}
