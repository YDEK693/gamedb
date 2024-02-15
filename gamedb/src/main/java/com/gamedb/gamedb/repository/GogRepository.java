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

    public Object getGames(){
        return  gogClient.getGames();
    }

    public Object getGame(String gameId){
        return  gogClient.getGames();
    }

}
