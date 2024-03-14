package com.gamedb.gamedb.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class LoginInfo {
    String mail;
    String password;
}
