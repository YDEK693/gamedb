package com.gamedb.gamedb.business;

import com.gamedb.gamedb.entity.AccountEntity;
import com.gamedb.gamedb.entity.AccountSettingsEntity;
import com.gamedb.gamedb.repository.AccountRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;

@Component
public class AccountBusiness {
    @Inject
    private AccountRepository accountRepository;

    public boolean Authenticate() {
        return true;
    }
    public AccountSettingsEntity getAccountSettings(int id) {
        return accountRepository.getAccountSettings(id);
    }
    public void updateAccountSettings(AccountSettingsEntity settings) {
        accountRepository.updateAccountSettings(settings);
    }
    public void createAccount(AccountEntity account) {
        accountRepository.createAccount(account);
    }
    public void updateAccount(AccountEntity account) {
        accountRepository.updateAccount(account);
    }
    public void deleteAccount(int id) {
        accountRepository.deleteAccount(id);
    }
}
