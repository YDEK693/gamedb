package com.gamedb.gamedb.entity;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class AccountEntity {
    int id;
    String name;
    String password;
    String mail;

}
