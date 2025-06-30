package org.finos.calm.mcp.api.clients;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.finos.calm.mcp.api.models.NamespaceResponse;

@RegisterRestClient(baseUri = "http://localhost:8080")
public interface NamespaceClient {
    @GET
    @Path("/calm/namespaces")
    NamespaceResponse getNamespaces();
}
