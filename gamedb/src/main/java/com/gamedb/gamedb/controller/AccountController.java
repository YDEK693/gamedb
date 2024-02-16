package com.gamedb.gamedb.controller;

import com.gamedb.gamedb.business.AccountBusiness;
import com.gamedb.gamedb.dto.Account;
import com.gamedb.gamedb.dto.AccountSettings;
import com.gamedb.gamedb.filter.AuthenticationRequired;
import com.gamedb.gamedb.mapper.AccountMapper;
import com.gamedb.gamedb.mapper.AccountSettingsMapper;
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
    @Path("/settings/{id}")
    @GET
    @AuthenticationRequired
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountSettings(@PathParam("id") int id) {
        return Response.ok(accountSettingsMapper.toDto(accountBusiness.getAccountSettings(id))).build();
    }
    @Path("/settings")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @AuthenticationRequired
    public Response updateAccountSettings(AccountSettings settings) {
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
