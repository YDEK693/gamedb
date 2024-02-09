package com.gamedb.gamedb.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class SteamGame implements Serializable {
    @JsonProperty("appid")
    protected int id = -1;

    @JsonProperty("name")
    protected String name = null;

    @JsonProperty("img_icon_url")
    protected String imgIcon = null;


    @JsonGetter("appid")
    public int getId() {
        return id;
    }
    @JsonGetter("name")
    public String getName() {
        return name;
    }
    @JsonGetter("img_icon_url")
    public String getImgIcon() {
        return imgIcon;
    }

    public void setId(int idSteam) {
        this.id = idSteam;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setImgIcon(String imgIcon) {
        this.imgIcon = imgIcon;
    }

}
