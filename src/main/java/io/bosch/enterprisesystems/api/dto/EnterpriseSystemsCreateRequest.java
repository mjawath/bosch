package io.bosch.enterprisesystems.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * EnterpriseSystemsRequest
 */
@Builder
@Getter
@Setter
public class EnterpriseSystemsCreateRequest {

    @NotNull
    private String name;
    @NotNull
    private String endpointUrl;
    private String authMethod;

}

