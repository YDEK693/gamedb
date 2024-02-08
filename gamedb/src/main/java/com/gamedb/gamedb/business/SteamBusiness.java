package com.gamedb.gamedb.business;


import com.gamedb.gamedb.dto.Response;
import com.gamedb.gamedb.dto.SteamResponse;
import com.gamedb.gamedb.repository.SteamRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;


@Component
public class SteamBusiness {
    @Inject()
    private SteamRepository steamRepository;

    public Object getGames(){
        return steamRepository.getGames();
    }

    public Response getGamesTest(){
        return steamRepository.getGamesTest();
    }





}
