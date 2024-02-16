package com.gamedb.gamedb.repository;


import com.gamedb.gamedb.dto.GogGame;
import com.gamedb.gamedb.dto.GogResponse;
import com.gamedb.gamedb.repository.client.GogClient;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;


@Component
public class GogRepository
{
    @Inject
    private GogClient gogClient;

    public GogResponse getGames(){
        return  gogClient.getGames();
    }

    public GogGame getGame(int gameId){
        return  gogClient.getGameInfo(gameId);
    }

}
