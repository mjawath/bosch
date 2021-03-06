package io.bosch.enterprisesystems.api.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EnterpriseSystemCreateResponse {
    private Long id;
    private String name;
    private String endpointUrl;
    private String authMethod;
}
