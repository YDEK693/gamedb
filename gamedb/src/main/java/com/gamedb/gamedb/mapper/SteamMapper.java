package com.gamedb.gamedb.mapper;


import com.gamedb.gamedb.dto.SteamGame;
import com.gamedb.gamedb.entity.SteamEntity;

public class SteamMapper {

    public static SteamGame toDto(SteamEntity entity) {
        SteamGame dto = new SteamGame();
        dto.setId(entity.getId());
       dto.setName(entity.getName());

        return dto;
    }

    public static SteamEntity toEntity(SteamGame dto) {
        SteamEntity entity = new SteamEntity();
        entity.setName(dto.getName());
        entity.setId(dto.getId());
        return entity;
    }
}
