package com.gamedb.gamedb.mapper;

import com.gamedb.gamedb.dto.GameDto;
import com.gamedb.gamedb.dto.SteamGame;
import com.gamedb.gamedb.dto.SteamGames;
import com.gamedb.gamedb.dto.SteamResponse;
import com.gamedb.gamedb.entity.GogEntity;
import com.gamedb.gamedb.entity.SteamEntity;

import java.net.MalformedURLException;
import java.net.URL;

public class GameMapper {
    public static GameDto SteamEntityToGameDtoMobile(SteamEntity entity) {
        GameDto game = new GameDto();
        game.setName(entity.getName());
        String img = "https://media.steampowered.com/steamcommunity/public/images/apps/"+entity.getId()+"/"+entity.getImgUrl()+".jpg";
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

    public static GameDto GogEntityToGameDtoComputer(GogEntity entity) {
        GameDto game = new GameDto();
        game.setName(entity.getName());
        game.setImageUrl(entity.getImage());
        return game;
    }

    public static GameDto GogEntityToGameDtoMobile(GogEntity entity) {
        GameDto game = new GameDto();
        game.setName(entity.getName());
        try {
            URL url = new URL(entity.getImage());
            URL httpsUrl = new URL("https", url.getHost(), url.getPort(), url.getFile());
            game.setImageUrl(httpsUrl.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return game;
    }
}
