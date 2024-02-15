package com.gamedb.gamedb.repository;


import com.gamedb.gamedb.dto.SteamResponse;
import com.gamedb.gamedb.repository.client.GogClient;
import jakarta.inject.Inject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class GogRepository
{
    @Inject
    private GogClient gogClient;

    public Object getGames(){
        return  gogClient.getGames();
    }

    public SteamResponse getGamesTest(String gameId){
        return  gogClient.getGameInfo(gameId);
    }

}
