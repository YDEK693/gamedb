package com.gamedb.gamedb.repository;

import com.gamedb.gamedb.entity.AccountEntity;
import com.gamedb.gamedb.entity.AccountSettingsEntity;
import jakarta.inject.Inject;
import org.h2.expression.Rownum;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Component
public class AccountRepository {
    private final static String SQL_GET_ACCOUNT = "SELECT * FROM accounts WHERE id = :id;";
    private final static String SQL_INSERT_ACCOUNT = "INSERT INTO accounts (name, password, mail) VALUES (:name, :password, :mail);";
    private final static String SQL_UPDATE_ACCOUNT = "UPDATE accounts SET name = :name, password = :password, mail = :mail WHERE id = :id;";
    private final static String SQL_DELETE_ACCOUNT = "DELETE FROM settings WHERE id = :id; DELETE FROM accounts WHERE id = :id;";
    private final static String SQL_INSERT_SETTINGS = "INSERT INTO settings (steamUser, gogUser) VALUES (null, null);";
    private final static String SQL_GET_SETTINGS = "SELECT * FROM settings WHERE id = :id";
    private final static String SQL_UPDATE_SETTINGS = "UPDATE settings SET steamUser = :steamUser, gogUser = :gogUser WHERE id = :id;";
    private final static String SQL_GET_ACCOUNT_BY_LOGIN = "SELECT * FROM ACCOUNTS where mail=:mail and password=:password;";
    private final static String SQL_GET_ACCOUNT_BY_TOKEN = "SELECT * FROM ACCOUNTS where mail=:mail and password=:password;";
    private final static String SQL_INSERT_LOGIN_TOKEN = "INSERT INTO tokens (id, token) VALUES (:id, :token);" ;
    private final static String SQL_GET_ID_BY_TOKEN = "SELECT * FROM token WHERE id = :id"
    @Inject
    private NamedParameterJdbcTemplate jdbcTemplate;
    public AccountEntity getAccount(int id) {
        var params = new HashMap<String, Object>();
        params.put("id", id);
        return this.jdbcTemplate.queryForObject(SQL_GET_ACCOUNT, params, AccountEntity.class);
    }

    public AccountEntity getAccountByLogin(String mail, String password) {
        var params = new HashMap<String, String>();
        params.put("mail", mail);
        params.put("password", password);
        System.out.println(params);
        List<AccountEntity> result = this.jdbcTemplate.query(SQL_GET_ACCOUNT_BY_LOGIN, params, (resultSet, rowNum) -> {
            AccountEntity account = new AccountEntity();
            account.setId(resultSet.getInt("ID"));
            account.setName(resultSet.getString("NAME"));
            System.out.println(account);
            return account;
        });
        if(result.size()>0){
            return result.get(0);
        }else{
            return null;
        }
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
        List<AccountSettingsEntity> result = this.jdbcTemplate.query(SQL_GET_SETTINGS, params, (resultSet, rowNum) -> {
            AccountSettingsEntity accountSettings = new AccountSettingsEntity();
            accountSettings.setId(resultSet.getInt("ID"));
            accountSettings.setSteamUser(resultSet.getString("STEAMUSER"));
            accountSettings.setGogUser(resultSet.getString("GOGUSER"));
            System.out.println(accountSettings);
            return accountSettings;
        });
        return result.get(0);
    }
    public void updateAccountSettings(AccountSettingsEntity settings) {
        var params = new HashMap<String, Object>();
        params.put("id", settings.getId());
        params.put("gogUser", settings.getGogUser());
        params.put("steamUser", settings.getSteamUser());
        this.jdbcTemplate.update(SQL_UPDATE_SETTINGS, params);
    }
    public void createToken(int id, String token) {
        var params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("token", token);
        this.jdbcTemplate.update(SQL_INSERT_LOGIN_TOKEN, params);
    }
    public AcccountEntity getAccountByToken(String token) {
        var params = new HashMap<String, String>();
        params.put("id", id);
        List<AccountEntity> result = this.jdbcTemplate.query(SQL_GET_ACCOUNT_BY params, (resultSet, rowNum) -> {
            AccountEntity account = new AccountEntity();
            account.setId(resultSet.getInt("ID"));
            account.setName(resultSet.getString("NAME"));
            System.out.println(account);
            return account;
        });
        if(result.size()>0){
            return result.get(0);
        }else{
            return null;
        }
    }
    public int getIdByToken(String token) {
        var params = new HashMap<String, String>();
        params.put("token", token);
        List<AccountEntity> result = this.jdbcTemplate.query(SQL_GET_ID_BY_TOKEN, params, (resultSet, rowNum) -> {
            AccountEntity account = new AccountEntity();
            account.setId(resultSet.getInt("ID"));
            account.setName(resultSet.getString("NAME"));
            System.out.println(account);
            return account;
        });
        if(result.size()>0){
            return result.get(0).getID();
        }else{
            return null;
        }
    }
}
