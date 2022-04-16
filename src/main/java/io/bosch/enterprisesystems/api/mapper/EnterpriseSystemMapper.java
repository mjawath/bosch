package io.bosch.enterprisesystems.api.mapper;

import io.bosch.enterprisesystems.api.dto.EnterpriseSystemDto;
import io.bosch.enterprisesystems.api.dto.EnterpriseSystemsCreateRequest;
import io.bosch.enterprisesystems.model.EnterpriseSystem;
import org.springframework.stereotype.Component;

@Component
public class EnterpriseSystemMapper {

    public EnterpriseSystem enterpriseSystemDtoToEnterpriseSystem(EnterpriseSystemDto enterpriseSystemDto) {
        return EnterpriseSystem.builder().build();
    }

    public EnterpriseSystem mapCreateToEntity(EnterpriseSystemsCreateRequest enterpriseSystemDto) {
        return EnterpriseSystem.builder()
                .endpointUrl(enterpriseSystemDto.getEndpointUrl())
                .name(enterpriseSystemDto.getName())
                .build();
    }

}
