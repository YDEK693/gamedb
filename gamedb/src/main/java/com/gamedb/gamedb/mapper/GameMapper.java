package com.gamedb.gamedb.mapper;

import com.gamedb.gamedb.dto.GameDto;
import com.gamedb.gamedb.dto.SteamGame;
import com.gamedb.gamedb.dto.SteamGames;
import com.gamedb.gamedb.dto.SteamResponse;
import com.gamedb.gamedb.entity.GogEntity;
import com.gamedb.gamedb.entity.SteamEntity;

public class GameMapper {
    public static GameDto SteamEntityToGameDtoMobile(SteamEntity entity) {
        GameDto game = new GameDto();
        game.setName(entity.getName());
        String img = "http://media.steampowered.com/steamcommunity/public/images/apps/"+entity.getId()+"/"+entity.getImgUrl()+".jpg";
        game.setImageUrl(img);
        return game;
    }

    public static GameDto SteamEntityToGameDtoComputer(SteamEntity entity) {
        GameDto game = new GameDto();
        game.setName(entity.getName());
        String img =  "https://cdn.akamai.steamstatic.com/steam/apps/"+entity.getId() +"/header.jpg";
        game.setImageUrl(img);
        return game;
    }

    public static GameDto GogEntityToGameDto(GogEntity entity) {
        GameDto game = new GameDto();
        game.setName(entity.getName());
        game.setImageUrl(entity.getImage()+".jpg");
        return game;
    }
}
