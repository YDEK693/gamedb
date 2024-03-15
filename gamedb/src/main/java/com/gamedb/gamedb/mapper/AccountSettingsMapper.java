package com.gamedb.gamedb.mapper;

import com.gamedb.gamedb.dto.AccountSettings;
import com.gamedb.gamedb.entity.AccountEntity;
import com.gamedb.gamedb.entity.AccountSettingsEntity;

public class AccountSettingsMapper {
    public AccountSettings toDto(AccountSettingsEntity settings) {
        AccountSettings acc = new AccountSettings();
        acc.setId(settings.getId());
        acc.setSteamUsername(settings.getSteamUser());
        acc.setGogUsername(settings.getGogUser());
        return acc;
    }
    public AccountSettingsEntity toEntity(AccountSettings settings) {
        AccountSettingsEntity acc= new AccountSettingsEntity();
        acc.setId(settings.getId());
        acc.setSteamUser(settings.getSteamUsername());
        acc.setGogUser(settings.getGogUsername());
        return acc;
    }
}
