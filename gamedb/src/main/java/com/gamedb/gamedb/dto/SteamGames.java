package com.gamedb.gamedb.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Error
 */
public class SteamGames implements Serializable{
    @JsonProperty("game_count")
    protected String gameCount = null;

    @JsonGetter("game_count")
    public String getGameCount() {
        return gameCount;
    }

    public void setGameCount(String gameCount) {
        this.gameCount = gameCount;
    }

}
