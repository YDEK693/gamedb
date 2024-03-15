package com.gamedb.gamedb.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class GogResponseAPI2 implements Serializable {
    @JsonProperty("_links")
    private GogLink links = null;
    @JsonGetter("_links")
    public GogLink getLinks() {
        return links;
    }
}
