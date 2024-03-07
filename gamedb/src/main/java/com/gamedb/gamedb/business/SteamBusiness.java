package com.gamedb.gamedb.business;


import com.gamedb.gamedb.dto.SteamGame;
import com.gamedb.gamedb.dto.SteamResponse;
import com.gamedb.gamedb.entity.SteamEntity;
import com.gamedb.gamedb.repository.SteamRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.gamedb.gamedb.mapper.SteamMapper.toEntity;


@Component
public class SteamBusiness {
    @Inject()
    private SteamRepository steamRepository;

    public List<SteamEntity> getGames(){
        List<SteamGame> games = steamRepository.getGames().getResponse().getGames();
        List<SteamEntity> entityGames = new ArrayList<>();
        for(SteamGame game: games){
            entityGames.add(toEntity(game));
        }
        return entityGames;
    }





}
