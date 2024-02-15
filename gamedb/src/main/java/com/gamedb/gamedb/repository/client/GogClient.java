package com.gamedb.gamedb.repository.client;

import com.gamedb.gamedb.dto.GogResponse;
import com.gamedb.gamedb.dto.SteamResponse;
import feign.Param;
import feign.RequestLine;

public interface GogClient {

    @RequestLine("GET /user/data/games")
    GogResponse getGames();

    @RequestLine("GET /account/gameDetails/{gameID}.json")
    Object getGameInfo(@Param("gameID")String gameId);
}
