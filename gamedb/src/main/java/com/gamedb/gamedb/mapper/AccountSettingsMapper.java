package com.gamedb.gamedb.mapper;

import com.gamedb.gamedb.dto.AccountSettings;
import com.gamedb.gamedb.entity.AccountEntity;
import com.gamedb.gamedb.entity.AccountSettingsEntity;

public class AccountSettingsMapper {
    public AccountSettings toDto(AccountSettingsEntity settings) {
        return new AccountSettings();
    }
    public AccountSettingsEntity toEntity(AccountSettings settings) {
        return new AccountSettingsEntity();
    }
}
