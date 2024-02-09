package com.gamedb.gamedb.dto;



import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class GameDto implements Serializable {
    @JsonProperty("name")
    protected String name = null;


    public void setName(String name) {
        this.name = name;
    }
}
