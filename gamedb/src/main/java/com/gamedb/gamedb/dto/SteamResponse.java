package com.gamedb.gamedb.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SteamResponse implements Serializable {
    @JsonProperty("response")
    private SteamGames response = null;

    @JsonGetter("response")
    public SteamGames getResponse() {
        return response;
    }
}
