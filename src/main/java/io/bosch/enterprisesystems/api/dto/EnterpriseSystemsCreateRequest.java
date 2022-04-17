package io.bosch.enterprisesystems.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * EnterpriseSystemsRequest
 */
@Builder
@Getter
@Setter
public class EnterpriseSystemsCreateRequest {

    private String name;
    private String endpointUrl;
    private String authMethod;

}

