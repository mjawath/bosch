package io.bosch.enterprisesystems.api.mapper;

import io.bosch.enterprisesystems.api.dto.EnterpriseSystemCreateResponse;
import io.bosch.enterprisesystems.api.dto.EnterpriseSystemResponse;
import io.bosch.enterprisesystems.api.dto.EnterpriseSystemsCreateRequest;
import io.bosch.enterprisesystems.model.EnterpriseSystem;
import org.springframework.stereotype.Component;

@Component
public class EnterpriseSystemMapper {

    public EnterpriseSystem enterpriseSystemDtoToEnterpriseSystem(EnterpriseSystemDto enterpriseSystemDto) {
        return EnterpriseSystem.builder().build();
    }

    public EnterpriseSystemCreateResponse mapEntityToCreateResponse(EnterpriseSystem enterpriseSystem) {
        return EnterpriseSystemCreateResponse.builder()
                .endpointUrl(enterpriseSystem.getEndpointUrl())
                .name(enterpriseSystem.getName())
                .endpointUrl(enterpriseSystem.getEndpointUrl())
                .build();
    }

    public EnterpriseSystemResponse mapEntityToResponse(EnterpriseSystem enterpriseSystem) {
        return EnterpriseSystemResponse.builder()
                .endpointUrl(enterpriseSystem.getEndpointUrl())
                .name(enterpriseSystem.getName())
                .endpointUrl(enterpriseSystem.getEndpointUrl())
                .build();
    }

    public EnterpriseSystem mapCreateToEntity(EnterpriseSystemsCreateRequest enterpriseSystemDto) {
        return EnterpriseSystem.builder()
                .endpointUrl(enterpriseSystemDto.getEndpointUrl())
                .name(enterpriseSystemDto.getName())
                .endpointUrl(enterpriseSystemDto.getEndpointUrl())
                .build();
    }

}
