package com.gamedb.gamedb.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Setter
public class AccountSettings implements Serializable {
    @JsonProperty
    int id;
    @JsonProperty
    String steamUsername;
    @JsonProperty
    String gogUsername;
    @JsonGetter
    public int getId() {
        return id;
    }
    @JsonGetter
    public String getSteamUsername() {
        return steamUsername;
    }
    @JsonGetter
    public String getGogUsername(){
        return gogUsername;
    }
}
