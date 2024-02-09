package com.gamedb.gamedb.dto;



import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class GameDto implements Serializable {
    @JsonProperty("name")
    protected String name = null;

    @JsonProperty("imageUrl")
    protected String imageUrl = null;


    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
