package io.bosch.enterprisesystems.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * EnterpriseSystem
 */
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class EnterpriseSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    private String endpointUrl;
    private String authmethod;

    public EnterpriseSystem id(Long id) {
        this.id = id;
        return this;
    }


    public EnterpriseSystem name(String name) {
        this.name = name;
        return this;
    }

    public EnterpriseSystem endpointUrl(String endpointUrl) {
        this.endpointUrl = endpointUrl;
        return this;
    }


    public String getEndpointUrl() {
        return endpointUrl;
    }

    public void setEndpointUrl(String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }

    public EnterpriseSystem authmethod(String authmethod) {
        this.authmethod = authmethod;
        return this;
    }

    public String getAuthmethod() {
        return authmethod;
    }

    public void setAuthmethod(String authmethod) {
        this.authmethod = authmethod;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnterpriseSystem enterpriseSystem = (EnterpriseSystem) o;
        return Objects.equals(this.id, enterpriseSystem.id) &&
                Objects.equals(this.name, enterpriseSystem.name) &&
                Objects.equals(this.endpointUrl, enterpriseSystem.endpointUrl) &&
                Objects.equals(this.authmethod, enterpriseSystem.authmethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, endpointUrl, authmethod);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnterpriseSystem {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    endpointUrl: ").append(toIndentedString(endpointUrl)).append("\n");
        sb.append("    authmethod: ").append(toIndentedString(authmethod)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

