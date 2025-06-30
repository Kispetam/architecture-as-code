package org.finos.calm.mcp.api.models;

import java.util.List;

/**
 * Response class containing a list of namespace identifiers.
 */
public class NamespaceResponse {
    private List<String> values;

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
