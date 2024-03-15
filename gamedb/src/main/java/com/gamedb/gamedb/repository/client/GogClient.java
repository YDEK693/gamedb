package com.gamedb.gamedb.repository.client;

import com.gamedb.gamedb.dto.GogGame;
import com.gamedb.gamedb.dto.GogResponse;
import com.gamedb.gamedb.dto.SteamResponse;
import feign.HeaderMap;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Headers("Authorization:{token}")
public interface GogClient {

    @RequestLine("GET /user/data/games")
    GogResponse getGames(@Param("token") String token);

    @RequestLine("GET /account/gameDetails/{gameID}.json")
    GogGame getGameInfo(@Param("token") String token, @Param("gameID")int gameId);
}
