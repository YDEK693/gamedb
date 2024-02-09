package com.gamedb.gamedb.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Error
 */
public class SteamGames implements Serializable{
    @JsonProperty("game_count")
    protected String gameCount = null;
    @JsonProperty("games")
    protected List<SteamGame> steamGames = null;
    @JsonGetter("game_count")
    public String getGameCount() {
        return gameCount;
    }

    @JsonGetter("games")
    public List<SteamGame> getGames() {
        return steamGames;
    }

    public void setGameCount(String gameCount) {
        this.gameCount = gameCount;
    }

}
