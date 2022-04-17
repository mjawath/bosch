package io.bosch.enterprisesystems.contract;


import io.bosch.enterprisesystems.EnterpriseSystemsApplication;
import io.bosch.enterprisesystems.api.EnterpriseSystemsApiController;
import io.bosch.enterprisesystems.model.EnterpriseSystem;
import io.bosch.enterprisesystems.service.EnterpriseSystemService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest(classes = EnterpriseSystemsApplication.class)
public abstract class EnterpriseSystemsBaseTestController {

    @Autowired
    EnterpriseSystemsApiController enterpriseSystemsApiController;

    @MockBean
    EnterpriseSystemService enterpriseSystemService;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(enterpriseSystemsApiController);

        Mockito.when(enterpriseSystemService.getById(1L))
                .thenReturn(Optional.ofNullable(
                        EnterpriseSystem
                                .builder()
                                .id(1L)
                                .name("Test")
                                .build()));
    }

}