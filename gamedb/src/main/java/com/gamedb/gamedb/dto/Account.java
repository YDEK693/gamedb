package com.gamedb.gamedb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    int id;
    String name;
    String password;
    String mail;
}
