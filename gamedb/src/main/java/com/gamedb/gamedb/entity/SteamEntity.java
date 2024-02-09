package com.gamedb.gamedb.entity;

public class SteamEntity {
    protected int id;
    protected String name;

    protected String imgUrl;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getImgUrl() {
        return imgUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
