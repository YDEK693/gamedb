package com.gamedb.gamedb.repository;


import com.gamedb.gamedb.dto.GogGames;
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

    public GogResponse getGame(String gameId){
        return  gogClient.getGames();
    }

}
