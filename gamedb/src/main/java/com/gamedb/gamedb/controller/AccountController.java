package com.gamedb.gamedb.controller;

import com.gamedb.gamedb.business.AccountBusiness;
import com.gamedb.gamedb.dto.Account;
import com.gamedb.gamedb.dto.AccountSettings;
import com.gamedb.gamedb.dto.Token;
import com.gamedb.gamedb.entity.AccountEntity;
import com.gamedb.gamedb.filter.AuthenticationRequired;
import com.gamedb.gamedb.mapper.AccountMapper;
import com.gamedb.gamedb.mapper.AccountSettingsMapper;
import com.gamedb.gamedb.mapper.TokenMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

@Controller
@Path("/account")
public class AccountController {
    @Inject
    AccountBusiness accountBusiness;
    AccountMapper accountMapper = new AccountMapper();
    AccountSettingsMapper accountSettingsMapper = new AccountSettingsMapper();
    TokenMapper tokenMapper = new TokenMapper();

    @Path("/details")
    @GET
    @AuthenticationRequired
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountByToken(@HeaderParam("Authentication") String tokenApp) {
        return Response.ok(accountMapper.toDto(accountBusiness.getAccountByToken(tokenApp))).build();
    }

    @Path("/settings/")
    @GET
    @AuthenticationRequired
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountSettings(@HeaderParam("Authentication") String tokenApp) {
        AccountEntity acc = accountBusiness.getAccountByToken(tokenApp);
        System.out.println("account"+acc);
        return Response.ok(accountSettingsMapper.toDto(accountBusiness.getAccountSettings(acc.getId()))).build();
    }
    @Path("/settings")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @AuthenticationRequired
    public Response updateAccountSettings(@HeaderParam("Authentication") String tokenApp, AccountSettings settings) {
        settings.setId(accountBusiness.getAccountByToken(tokenApp).getId());
        System.out.println("settings put"+settings.getGogUsername()+" "+settings.getGogUsername()+" id"+settings.getId() );
        this.accountBusiness.updateAccountSettings(accountSettingsMapper.toEntity(settings));
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAccount(Account account) {
        this.accountBusiness.createAccount(accountMapper.toEntity(account));
        return Response.ok("Account created").build();
    }

    @PUT
    @AuthenticationRequired
    public Response updateAccount(Account account) {
        this.accountBusiness.updateAccount(accountMapper.toEntity(account));
        return Response.ok().build();
    }
    @DELETE
    @AuthenticationRequired
    public Response deleteAccount(int id) {
        this.accountBusiness.deleteAccount(id);
        return Response.ok().build();
    }
}
