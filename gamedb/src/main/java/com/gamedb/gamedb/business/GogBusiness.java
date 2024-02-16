package com.gamedb.gamedb.business;

import com.gamedb.gamedb.dto.GogGame;
import com.gamedb.gamedb.dto.GogResponse;
import com.gamedb.gamedb.dto.SteamGame;
import com.gamedb.gamedb.entity.SteamEntity;
import com.gamedb.gamedb.repository.GogRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.gamedb.gamedb.mapper.SteamMapper.toEntity;

@Component
public class GogBusiness {

    @Inject()
    private GogRepository gogRepository;

    public List<GogGame> getGames(){
        GogResponse games = gogRepository.getGames();
        List<GogGame> entityGames = new ArrayList<>();
        for(int i : games.getResponse()){
            //entityGames.add()
        }
        return null;
    }
    public Object getGame(){
        return gogRepository.getGames();
    }
}
