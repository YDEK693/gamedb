package com.gamedb.gamedb.repository;

import com.gamedb.gamedb.entity.AccountEntity;
import com.gamedb.gamedb.entity.AccountSettingsEntity;
import jakarta.inject.Inject;
import org.h2.expression.Rownum;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class AccountRepository {
    private final static String SQL_GET_ACCOUNT = "SELECT * FROM accounts WHERE id = :id;";
    private final static String SQL_INSERT_ACCOUNT = "INSERT INTO accounts (id, name, password, mail) VALUES (DEFAULT, :name, :password, :mail);";
    private final static String SQL_UPDATE_ACCOUNT = "UPDATE accounts SET name = :name, password = :password, mail = :mail WHERE id = :id;";
    private final static String SQL_DELETE_ACCOUNT = "DELETE FROM accounts WHERE id = :id;";
    private final static String SQL_INSERT_SETTINGS =
            "INSERT INTO settings (steamUser, gogUser, id)" +
            "SELECT (null, null, id)" +
            "WHERE id = (SELECT MAX(id) FROM accounts);";
    private final static String SQL_GET_SETTINGS = "SELECT * FROM settings WHERE id = :id";
    private final static String SQL_UPDATE_SETTINGS = "UPDATE settings SET steamUser = :steamUser, gogUser = :gogUser WHERE id = :id;";
    @Inject
    private NamedParameterJdbcTemplate jdbcTemplate;
    public AccountEntity getAccount(int id) {
        var params = new HashMap<String, Object>();
        params.put("id", id);
        return this.jdbcTemplate.queryForObject(SQL_GET_ACCOUNT, params, AccountEntity.class);
    }
    public void createAccount(AccountEntity account) {
        var params = new HashMap<String, Object>();
        params.put("id", 1);
        params.put("name", account.getName());
        params.put("password", account.getPassword());
        params.put("mail", account.getMail());
        this.jdbcTemplate.update(SQL_INSERT_ACCOUNT, params);
        this.jdbcTemplate.update(SQL_INSERT_SETTINGS, params);
    }
    public void updateAccount(AccountEntity account) {
        var params = new HashMap<String, Object>();
        params.put("name", account.getName());
        params.put("password", account.getPassword());
        params.put("mail", account.getMail());
        this.jdbcTemplate.update(SQL_UPDATE_ACCOUNT, params);
    }
    public void deleteAccount(int id) {
        var params = new HashMap<String, Object>();
        params.put("id", id);
        this.jdbcTemplate.update(SQL_DELETE_ACCOUNT, params);
    }
    public AccountSettingsEntity getAccountSettings(int id) {
        var params = new HashMap<String, Object>();
        params.put("id", id);
        return this.jdbcTemplate.queryForObject(SQL_GET_SETTINGS, params, AccountSettingsEntity.class);
    }
    public void updateAccountSettings(AccountSettingsEntity settings) {
        var params = new HashMap<String, Object>();
        params.put("id", settings.getId());
        params.put("gogUser", settings.getGogUser());
        params.put("steamUser", settings.getSteamUser());
        this.jdbcTemplate.update(SQL_UPDATE_SETTINGS, params);
    }
}
