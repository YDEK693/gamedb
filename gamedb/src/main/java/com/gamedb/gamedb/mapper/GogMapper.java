package com.gamedb.gamedb.mapper;

import com.gamedb.gamedb.dto.GogGame;
import com.gamedb.gamedb.dto.SteamGame;
import com.gamedb.gamedb.entity.GogEntity;
import com.gamedb.gamedb.entity.SteamEntity;

public class GogMapper {

    public static GogGame toDto(GogEntity entity) {
        GogGame dto = new GogGame();
        dto.setTitle(entity.getName());
        dto.setImage(entity.getImage());
        return dto;
    }

    public static GogEntity toEntity(GogGame dto) {
        GogEntity entity = new GogEntity();
        entity.setName(dto.getTitle());
        entity.setImage(dto.getBackgroundImage());
        return entity;
    }
}
