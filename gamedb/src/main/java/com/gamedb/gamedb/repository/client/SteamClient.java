package com.gamedb.gamedb.repository.client;


import com.gamedb.gamedb.dto.SteamResponse;
import feign.Param;
import feign.RequestLine;

public interface SteamClient {
    //@Cacheable(value = "weather", key ="#cityName")
    
    @RequestLine("GET IPlayerService/GetOwnedGames/v0001/?key={key}&steamid={steamid}&include_appinfo=true")
    Object getGame(@Param("key")String key, @Param("steamid")String steamid);

    @RequestLine("GET IPlayerService/GetOwnedGames/v0001/?key={key}&steamid={steamid}&include_appinfo=true")
    SteamResponse getGames(@Param("key")String key, @Param("steamid")String steamid);
}
