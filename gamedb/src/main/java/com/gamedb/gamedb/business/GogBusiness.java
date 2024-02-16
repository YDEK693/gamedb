package com.gamedb.gamedb.business;

import com.gamedb.gamedb.dto.GogGame;
import com.gamedb.gamedb.dto.GogResponse;

import com.gamedb.gamedb.entity.GogEntity;
import com.gamedb.gamedb.repository.GogRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.gamedb.gamedb.mapper.GogMapper.toEntity;

@Component
public class GogBusiness {

    @Inject()
    private GogRepository gogRepository;

    public List<GogEntity> getGames(){
        GogResponse games = gogRepository.getGames();
        List<GogEntity> entityGames = new ArrayList<>();
        for(int i : games.getResponse()){
            entityGames.add(toEntity(this.getGame(i)));
        }
        return entityGames;
    }
    public GogGame getGame(int gameid){
        return gogRepository.getGame(gameid);
    }
}
