package com.uniyaz.rest;

import com.uniyaz.core.domain.Musteri;
import com.uniyaz.core.service.MusteriService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by AKARTAL on 17.3.2021.
 */
@Path("/musteri")
public class MusteriController {

    @GET
    @Path("/findAll")
    @Produces("application/json")
    public List<Musteri> findAll() {
        MusteriService musteriService = new MusteriService();
        List<Musteri> musteriList = musteriService.findAll();
        return musteriList;
    }

    @GET
    @Path("/hello")
    public Response sayHello() {
        String output = "HELLO ";
        return Response.status(200).entity(output).build();
    }
}