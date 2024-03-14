package com.gamedb.gamedb.repository;

import com.gamedb.gamedb.dto.SteamResponse;
import com.gamedb.gamedb.repository.client.SteamClient;
import jakarta.inject.Inject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class SteamRepository {
    @Inject
    private SteamClient steamClient;

    @Value("${spring.secrets.steam.key}")
    private String key;

    //@Value("${spring.secrets.steam.steamid}")
    //private String steamid;

    private String token;


    public SteamResponse getGames(String steamId){
        return  steamClient.getGames(key, steamId);
    }

}
