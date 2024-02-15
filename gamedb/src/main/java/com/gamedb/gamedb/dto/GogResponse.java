package com.gamedb.gamedb.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class GogResponse implements Serializable {
    @JsonProperty("owned")
    private GogGames owned = null;

    @JsonGetter("owned")
    public GogGames getResponse() {
        return owned;
    }
}
