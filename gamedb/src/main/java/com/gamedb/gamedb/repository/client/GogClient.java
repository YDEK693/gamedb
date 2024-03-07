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

@Headers("Authorization: Bearer DB4JwzHN-9acb-McOwLGamteL_b04UNIKYMg5VsTvgb41Kok4kwn2KqlM-xLEFNuiDDOAgqbFoOqTyVI-r69bW068OlvbbLVzyipEA3Eteg4A3FnO5pl62n_-wLcxQA2gfolAQkpzVopCVO9w5gIojFcdZPFPnH9l2uR-j6gUbCEJlEvADB4FiIyO9G6N92b")
public interface GogClient {

    @RequestLine("GET /user/data/games")


    GogResponse getGames();

    @RequestLine("GET /account/gameDetails/{gameID}.json")
    GogGame getGameInfo(@Param("gameID")int gameId);
}
