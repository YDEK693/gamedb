package com.gamedb.gamedb.repository.client;

import com.gamedb.gamedb.dto.GogResponse;
import com.gamedb.gamedb.dto.SteamResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
@Headers("Accept-Language: en-US")
public interface GogClient {

    @RequestLine("GET /user/data/games")
    Object getGames();

    @RequestLine("GET /account/gameDetails/{gameID}.json")
    Object getGameInfo(@Param("gameID")String gameId);
}
