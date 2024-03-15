package com.gamedb.gamedb.repository.client;

import com.gamedb.gamedb.dto.GogGame;
import com.gamedb.gamedb.dto.GogResponse;
import com.gamedb.gamedb.dto.GogResponseAPI2;
import feign.Headers;
import feign.Param;
import feign.RequestLine;


public interface GogClientAPI2 {

    @RequestLine("GET /games/{gameId}")
    GogResponseAPI2 getGameInfo(@Param("gameId") int gameId);
}
