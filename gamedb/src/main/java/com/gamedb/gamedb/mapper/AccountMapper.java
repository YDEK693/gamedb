package com.gamedb.gamedb.mapper;

import com.gamedb.gamedb.dto.Account;
import com.gamedb.gamedb.entity.AccountEntity;

public class AccountMapper {

    public AccountEntity toEntity(Account account) {
        AccountEntity entity = new AccountEntity();
        entity.setId(account.getId());
        entity.setName(account.getName());
        entity.setPassword(account.getPassword());
        entity.setMail(account.getMail());
        return entity;
    }
}
