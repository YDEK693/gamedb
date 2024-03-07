package com.gamedb.gamedb.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Link implements Serializable {
    @JsonProperty("href")
    private String href;

    @JsonGetter("href")
    public String getRef(){
        return href;
    }
}