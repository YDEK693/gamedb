package com.gamedb.gamedb.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class GogResponse implements Serializable {
    @JsonProperty("owned")
    private List<Integer> games = null;
    @JsonGetter("owned")
    public List<Integer> getResponse() {
        return games;
    }
}
