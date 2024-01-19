package com.gamedb.gamedb.repository;

import com.gamedb.gamedb.repository.client.SteamClient;
import jakarta.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
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

}
