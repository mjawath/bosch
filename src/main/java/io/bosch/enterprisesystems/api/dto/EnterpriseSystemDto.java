package io.bosch.enterprisesystems.api.dto;

import java.io.Serializable;
import java.util.Objects;

public class EnterpriseSystemDto implements Serializable {
    private final String id;
    private final String endpointUrl;
    private final String authmethod;
    private final String name;

    public EnterpriseSystemDto(String id, String endpointUrl, String authmethod, String name) {
        this.id = id;
        this.endpointUrl = endpointUrl;
        this.authmethod = authmethod;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getEndpointUrl() {
        return endpointUrl;
    }

    public String getAuthmethod() {
        return authmethod;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnterpriseSystemDto entity = (EnterpriseSystemDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.endpointUrl, entity.endpointUrl) &&
                Objects.equals(this.authmethod, entity.authmethod) &&
                Objects.equals(this.name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, endpointUrl, authmethod, name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "endpointUrl = " + endpointUrl + ", " +
                "authmethod = " + authmethod + ", " +
                "name = " + name + ")";
    }
}
