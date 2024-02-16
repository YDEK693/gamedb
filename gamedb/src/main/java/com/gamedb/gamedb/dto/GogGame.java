package com.gamedb.gamedb.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class GogGame implements Serializable {

    String backgroundImage;
    @JsonProperty("title")
    String title;
    @JsonGetter("title")
    public String getTitle(){
        return title;
    }

}
