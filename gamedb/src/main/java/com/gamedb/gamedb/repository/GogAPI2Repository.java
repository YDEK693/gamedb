package com.gamedb.gamedb.repository;


import com.gamedb.gamedb.dto.GogGame;
import com.gamedb.gamedb.dto.GogResponse;
import com.gamedb.gamedb.dto.GogResponseAPI2;
import com.gamedb.gamedb.repository.client.GogClient;
import com.gamedb.gamedb.repository.client.GogClientAPI2;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;


@Component
public class GogAPI2Repository
{
    @Inject
    private GogClientAPI2 gogClient;


    public GogResponseAPI2 getGame(int gameId){
        return  gogClient.getGameInfo(gameId);
    }

}
