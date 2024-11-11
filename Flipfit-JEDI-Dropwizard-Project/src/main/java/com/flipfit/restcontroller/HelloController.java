package com.flipfit.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello-api")
@Produces(MediaType.APPLICATION_JSON)
public class HelloController {
    @GET
    @Path("/hello-get")
    public String helloServiceGet() {

        return "This is my first service";
    }

    @POST
    @Path("/hello-post")
    public String helloServicePost() {

        return "This is my first service";
    }

    @PUT
    @Path("/hello-put")
    public String helloServicePut() {

        return "This is my first service";
    }

    @DELETE
    @Path("/hello-delete")
    public String helloServiceDelete() {

        return "This is my first service";
    }
}