package com.gamedb.gamedb.repository.client;

import com.gamedb.gamedb.dto.SteamResponse;
import feign.Param;
import feign.RequestLine;

public interface GogClient {
    //@Cacheable(value = "weather", key ="#cityName")
    @RequestLine("GET /user/data/games")
    Object getGames();

    @RequestLine("GET /account/gameDetails/{gameID}.json")
    SteamResponse getGameInfo(@Param("gameId")String gameId);
}
