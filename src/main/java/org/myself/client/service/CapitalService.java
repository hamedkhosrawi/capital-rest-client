package org.myself.client.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import org.myself.client.model.Capital;


import java.util.Set;
import java.util.concurrent.CompletionStage;


@Path("/capital")
@RegisterRestClient(configKey = "capital-api")
@ClientHeaderParam(name = "test", value = "constant-value")
@RegisterClientHeaders(RequestUUIDHeaderFactory.class)
public interface CapitalService {

    @GET
    @Path("/{name}")
    Set<Capital> getByName(@PathParam("name") String name);

    @GET
    @Path("/{name}")
    CompletionStage<Set<Capital>> getByNameAsync(@PathParam("name") String name);
}
