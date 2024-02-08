package com.gamedb.gamedb.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

@Controller
@Path("/games")
public class GameController {
    @GET
    public Response getGames() {
        String list = "[" +
                "{ 'name' : 'vampire survivors'}," +
                "{ 'name' : 'dwarf fortress'},";
        return Response.ok(list).build();
    }
}
