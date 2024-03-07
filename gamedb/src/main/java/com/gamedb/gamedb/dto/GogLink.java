package com.gamedb.gamedb.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;

public class GogLink implements Serializable {
    @JsonProperty("icon")
    private Link icon;

    @JsonProperty("boxArtImage")
    private Link boxArtImage;


    @JsonGetter("icon")
    public Link getIcon(){
        return icon;
    }
    @JsonGetter("boxArtImage")
    public Link getBoxArtImage(){
        return boxArtImage;
    }

}
