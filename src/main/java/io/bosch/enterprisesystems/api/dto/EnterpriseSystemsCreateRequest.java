package io.bosch.enterprisesystems.api.dto;

import lombok.Builder;

/**
 * EnterpriseSystemsRequest
 */
@Builder
public class EnterpriseSystemsCreateRequest {

    private String name;
    private String endpointUrl;
    private String authMethod;

}

