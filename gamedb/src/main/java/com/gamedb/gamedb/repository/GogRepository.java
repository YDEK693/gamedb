package com.gamedb.gamedb.repository;


import com.gamedb.gamedb.dto.GogGame;
import com.gamedb.gamedb.dto.GogResponse;
import com.gamedb.gamedb.repository.client.GogClient;
import com.gamedb.gamedb.repository.client.GogClientAPI2;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class GogRepository
{
    @Inject
    private GogClient gogClient;

    public GogResponse getGames(String token){
        return  gogClient.getGames(token);
    }

    public GogGame getGame(String token, int gameId){
        return  gogClient.getGameInfo(token, gameId);
    }

}
