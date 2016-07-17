package com.renanpalmeira.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class Resource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "Hello JAX RS";
    }
}