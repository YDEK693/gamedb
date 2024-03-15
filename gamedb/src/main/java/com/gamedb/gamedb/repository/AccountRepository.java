package com.gamedb.gamedb.repository;

import com.gamedb.gamedb.entity.AccountEntity;
import com.gamedb.gamedb.entity.AccountSettingsEntity;
import com.gamedb.gamedb.entity.TokenEntity;
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
    private final static String SQL_INSERT_SETTINGS = "INSERT INTO settings (id,steamUser, gogUser) VALUES (:id,'vide', 'vide');";
    private final static String SQL_GET_SETTINGS = "SELECT * FROM settings WHERE id = :id";
    private final static String SQL_UPDATE_SETTINGS = "UPDATE settings SET steamUser = :steamUser, gogUser = :gogUser WHERE id = :id;";
    private final static String SQL_GET_ACCOUNT_BY_LOGIN = "SELECT * FROM ACCOUNTS where mail=:mail and password=:password;";
    //private final static String SQL_GET_ACCOUNT_BY_TOKEN = "SELECT * FROM ACCOUNTS where mail=:mail and password=:password;";
    private final static String SQL_GET_ACCOUNT_BY_ID = "SELECT * FROM ACCOUNTS where id=:id;";
    private final static String SQL_INSERT_FIRST_LOGIN_TOKEN = "INSERT INTO tokens (id, loginToken) VALUES (:id, :token);" ;
    private final static String SQL_GET_LOGIN_TOKEN = "SELECT * FROM tokens WHERE id =:id;" ;
    private final static String SQL_INSERT_LOGIN_TOKEN = "Update tokens set loginToken=:token where id=:id;" ;
    private final static String SQL_GET_ID_BY_TOKEN = "SELECT * FROM tokens INNER JOIN accounts ON tokens.id = accounts.id WHERE tokens.loginToken = :token";
    @Inject
    private NamedParameterJdbcTemplate jdbcTemplate;
    public AccountEntity getAccount(int id) {
        var params = new HashMap<String, Object>();
        params.put("id", id);
        return this.jdbcTemplate.queryForObject(SQL_GET_ACCOUNT, params, AccountEntity.class);
    }
    public AccountEntity getAccountById(int id) {
        var params = new HashMap<String, Object>();
        params.put("id", id);
        System.out.println(params);
        List<AccountEntity> result = this.jdbcTemplate.query(SQL_GET_ACCOUNT_BY_ID, params, (resultSet, rowNum) -> {
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
        params.put("id", null);
        params.put("name", account.getName());
        params.put("password", account.getPassword());
        params.put("mail", account.getMail());
        this.jdbcTemplate.update(SQL_INSERT_ACCOUNT, params);

        AccountEntity countnewlycreated = this.getAccountByLogin(account.getMail(), account.getPassword());
        params.put("id", countnewlycreated.getId());
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
        this.jdbcTemplate.update(SQL_INSERT_FIRST_LOGIN_TOKEN, params);
    }


    public void updateToken(int id, String token) {
        var params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("token", token);
        this.jdbcTemplate.update(SQL_INSERT_LOGIN_TOKEN, params);
    }
    public boolean checkTokenExist(int id) {
        var params = new HashMap<String,Integer>();
        params.put("id",id);
        List<TokenEntity> result = this.jdbcTemplate.query(SQL_GET_LOGIN_TOKEN, params, (resultSet, rowNum) -> {
            TokenEntity token = new TokenEntity();

            return token;
        });
        if(result.size()==1){
            return true;
        }else{
            return false;
        }

    }

    public AccountEntity getAccountByToken(String token) {
        return this.getAccountById(this.getIdByToken(token));
    }
    public int getIdByToken(String token) {
        var params = new HashMap<String, String>();
        params.put("token", token);
        System.out.println("token" + token);
        List<AccountEntity> result = this.jdbcTemplate.query(SQL_GET_ID_BY_TOKEN, params, (resultSet, rowNum) -> {
            AccountEntity account = new AccountEntity();
            account.setId(resultSet.getInt("ID"));
            account.setName(resultSet.getString("NAME"));
            System.out.println(account);
            return account;
        });
        System.out.println("result" + result);
        if (result.size() > 0) {
            return result.get(0).getId();
        } else {
            return -1;
        }
    }
   /* public int getIdByToken(String token) {
        var params = new HashMap<String, String>();
        params.put("token", token);
        System.out.println("token"+token);
        List<AccountEntity> result = this.jdbcTemplate.query(SQL_GET_ID_BY_TOKEN, params, (resultSet, rowNum) -> {
            AccountEntity account = new AccountEntity();
            account.setId(resultSet.getInt("ID"));
            account.setName(resultSet.getString("NAME"));
            System.out.println(account);
            return account;
        });
        System.out.println("result"+result);
        if(result.size()>0){
            return result.get(0).getId();
        }else{
            return -1;
        }
    }*/

}
