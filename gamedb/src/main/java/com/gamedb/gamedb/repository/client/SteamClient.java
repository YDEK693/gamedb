package com.gamedb.gamedb.repository.client;


import com.gamedb.gamedb.dto.Response;
import com.gamedb.gamedb.dto.SteamResponse;
import feign.Param;
import feign.RequestLine;
import org.springframework.cache.annotation.Cacheable;

public interface SteamClient {
    //@Cacheable(value = "weather", key ="#cityName")
    @RequestLine("GET IPlayerService/GetOwnedGames/v0001/?key={key}&steamid={steamid}&include_appinfo=true")
    Object getGame(@Param("key")String key, @Param("steamid")String steamid);

    @RequestLine("GET IPlayerService/GetOwnedGames/v0001/?key={key}&steamid={steamid}&include_appinfo=true")
    Response getGameTest(@Param("key")String key, @Param("steamid")String steamid);
}
