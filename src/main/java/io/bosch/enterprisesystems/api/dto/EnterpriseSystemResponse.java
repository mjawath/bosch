package io.bosch.enterprisesystems.api.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EnterpriseSystemResponse implements Serializable {
    private Long id;
    private String name;
    private String endpointUrl;
    private String authMethod;
}
