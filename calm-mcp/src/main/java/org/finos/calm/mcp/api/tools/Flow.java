package org.finos.calm.mcp.api.tools;

import io.quarkiverse.mcp.server.Tool;
import io.quarkiverse.mcp.server.ToolArg;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.finos.calm.mcp.api.clients.FlowClient;
import org.finos.calm.mcp.api.models.FlowInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * CALM MCP tool for managing flows.
 * Provides functionality to retrieve flow identifiers for specific namespaces.
 */
public class Flow {

    private final Logger log = LoggerFactory.getLogger(Flow.class);

    @RestClient
    FlowClient flowClient;

    @Tool(
            name = "getFlows",
            description = "Returns a list of Flow identifiers for a specific namespace in CALM. Flows define how data or processes move through the system and represent the dynamic aspects of the architecture. Requires a namespace parameter to specify which namespace to retrieve flows from."
    )
    public List<FlowInformation> getFlows(@ToolArg(description = "Name of CALM namespace") String namespace) {
        if (namespace == null || namespace.trim().isEmpty()) {
            log.error("Namespace parameter is null or empty");
            throw new IllegalArgumentException("Namespace parameter is required");
        }
        
        log.info("Retrieving flows for namespace: {}", namespace);
        return flowClient.getFlows(namespace).getValues()
                .stream()
                .map(flowId -> new FlowInformation(namespace, flowId))
                .toList();
    }
}
