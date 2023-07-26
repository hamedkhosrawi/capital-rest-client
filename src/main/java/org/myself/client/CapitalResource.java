package org.myself.client;



import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestQuery;
import org.myself.client.model.Capital;
import org.myself.client.service.CapitalService;

import java.util.Set;
import java.util.concurrent.CompletionStage;

@Path("/capital")
public class CapitalResource {

    @RestClient
    CapitalService capitalService;

    @GET
    @Path("/info/{name}")
    public Set<Capital> name(@PathParam("name") String name){
       return capitalService.getByName(name);
    }


    @GET
    @Path("/info-async/{name}")
    public CompletionStage<Set<Capital>> nameAsync(@PathParam("name") String name){
        return capitalService.getByNameAsync(name);
    }



}
