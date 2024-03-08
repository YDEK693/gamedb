package com.gamedb.gamedb.business;

import com.gamedb.gamedb.dto.Account;
import com.gamedb.gamedb.entity.AccountEntity;
import com.gamedb.gamedb.entity.AccountSettingsEntity;
import com.gamedb.gamedb.mapper.AccountMapper;
import com.gamedb.gamedb.repository.AccountRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;

@Component
public class AccountBusiness {
    @Inject
    private AccountRepository accountRepository;

    public AccountEntity getAccountByToken(Token token) {
        AccountEntity acc = accountRepository.getAccountByToken(token.getToken());
        return acc;
    }
    public String Authenticate(String mail, String password) {
        AccountEntity acc= accountRepository.getAccountByLogin(mail, password);

        if(acc!= null) {
            String token = this.generateToken(mail, password);
            accountRepository.createToken(acc.getId(),token);
            return token;
        }
        return null;
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
    public String generateToken(String a, String b) {
        return a+b;
    }
}
