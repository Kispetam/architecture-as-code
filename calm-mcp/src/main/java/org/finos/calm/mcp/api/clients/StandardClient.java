package org.finos.calm.mcp.api.clients;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.finos.calm.mcp.api.models.StandardResponse;

@RegisterRestClient(baseUri = "http://localhost:8080")
public interface StandardClient {
    @GET
    @Path("/calm/namespaces/{namespace}/standards")
    StandardResponse getStandards(@PathParam("namespace") String namespace);
}
