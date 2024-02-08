package com.gamedb.gamedb.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

/**
 * Error
 */
public class SteamResponse implements Serializable{
    @JsonProperty("game_count")
    protected String gameCount = null;

    @JsonProperty("game_count")
    public String getGameCount() {
        return gameCount;
    }

    public void setGameCount(String gameCount) {
        this.gameCount = gameCount;
    }

}
