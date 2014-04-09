package com.example.resources;

import com.example.core.User;
import com.example.views.UsersView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;

@Path("/")
@Produces({MediaType.TEXT_HTML})
public class UserResource {

    public UserResource() {
        super();
    }

    @GET
    @Path("user")
    public UsersView fetch(){
        List<User> users = new LinkedList<>();
        users.add(
            new User()
                .setUsername("user1")
                .setDisplayName("User 1")
                .setDisplayRole("Admin")
        );
        users.add(
                new User()
                        .setUsername("user2")
                        .setDisplayName("User 2")
                        .setDisplayRole("DBA")
        );

        return new UsersView(users);
    }

    @GET
    @Path("error")
    public UsersView error() {
        throw new RuntimeException("You've been eaten by a Grue");
    }

    @GET
    @Path("401")
    public UsersView error401() {
        throw new WebApplicationException(401);
    }
}
