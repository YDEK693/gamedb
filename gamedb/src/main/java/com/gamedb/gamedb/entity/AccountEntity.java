package com.gamedb.gamedb.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountEntity {
    int id;
    String name;
    String password;
    String mail;

}
