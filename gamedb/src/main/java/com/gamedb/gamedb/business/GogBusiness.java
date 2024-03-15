package com.gamedb.gamedb.business;

import com.gamedb.gamedb.dto.GogGame;
import com.gamedb.gamedb.dto.GogResponse;

import com.gamedb.gamedb.dto.GogResponseAPI2;
import com.gamedb.gamedb.entity.GogEntity;
import com.gamedb.gamedb.repository.GogAPI2Repository;
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

    @Inject()
    private GogAPI2Repository gogAPI2RepositoryRepository;

    public List<GogEntity> getGamesComputer(String token){

        GogResponse games = gogRepository.getGames(token);
        List<GogEntity> entityGames = new ArrayList<>();
        for(int i : games.getResponse()){
            GogGame game =this.getGame(token, i);
            game.setImage( gogAPI2RepositoryRepository.getGame(i).getLinks().getBoxArtImage().getRef());
            entityGames.add(toEntity(game));
        }

        return entityGames;
    }

    public List<GogEntity> getGamesMobile(String token){

        GogResponse games = gogRepository.getGames(token);
        List<GogEntity> entityGames = new ArrayList<>();
        for(int i : games.getResponse()){
            GogGame game =this.getGame(token, i);
            game.setImage( gogAPI2RepositoryRepository.getGame(i).getLinks().getIcon().getRef());
            entityGames.add(toEntity(game));
        }

        return entityGames;
    }
    public GogGame getGame(String token, int gameid) {


        return gogRepository.getGame(token, gameid);
    }
}
