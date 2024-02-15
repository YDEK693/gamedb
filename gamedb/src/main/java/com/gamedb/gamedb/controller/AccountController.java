package com.gamedb.gamedb.controller;

import com.gamedb.gamedb.business.AccountBusiness;
import com.gamedb.gamedb.dto.Account;
import com.gamedb.gamedb.dto.AccountSettings;
import com.gamedb.gamedb.filter.AuthenticationRequired;
import com.gamedb.gamedb.mapper.AccountMapper;
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
    @Path("/settings/{id}")
    @GET
    @AuthenticationRequired
    public Response getAccountSettings(@PathParam("id") int id) {
        return Response.ok(accountBusiness.getAccountSettings(id)).build();
    }
    @Path("/settings")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @AuthenticationRequired
    public Response updateAccountSettings(AccountSettings settings) {
        return null;
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
    public Response updateAccount() {
        return null;
    }
    @DELETE
    @AuthenticationRequired
    public Response deleteAccount() {
        return null;
    }

}
