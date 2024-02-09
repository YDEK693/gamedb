package com.gamedb.gamedb.mapper;

import com.gamedb.gamedb.dto.GameDto;
import com.gamedb.gamedb.dto.SteamGame;
import com.gamedb.gamedb.dto.SteamGames;
import com.gamedb.gamedb.dto.SteamResponse;
import com.gamedb.gamedb.entity.SteamEntity;

public class GameMapper {
    public static GameDto SteamEntityToGameDto(SteamEntity entity) {
        GameDto game = new GameDto();
        game.setName(entity.getName());
        String img = "http://media.steampowered.com/steamcommunity/public/images/apps/"+entity.getId()+"/"+entity.getImgUrl()+".jpg";
        game.setImageUrl(img);
        return game;
    }
}
