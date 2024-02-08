package com.gamedb.gamedb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Response implements Serializable {
    @JsonProperty("response")
    private  SteamResponse response = null;

    @JsonProperty("response")
    public SteamResponse getResponse() {
        return response;
    }
}
