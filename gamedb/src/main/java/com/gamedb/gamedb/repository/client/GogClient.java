package com.gamedb.gamedb.repository.client;

import com.gamedb.gamedb.dto.GogGame;
import com.gamedb.gamedb.dto.GogResponse;
import com.gamedb.gamedb.dto.SteamResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
@Headers("Accept-Language: en-US")
public interface GogClient {

    @RequestLine("GET /user/data/games")
    GogResponse getGames();

    @RequestLine("GET /account/gameDetails/{gameID}.json")
    GogGame getGameInfo(@Param("gameID")int gameId);
}
