package com.gamedb.gamedb.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
@Setter
public class GogGame implements Serializable {


    String image;
    @JsonProperty("title")
    String title;
    @JsonGetter("title")
    public String getTitle(){
        return title;
    }


    public String getBackgroundImage(){
        return image;
    }



}
