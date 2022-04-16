package io.bosch.enterprisesystems.service;

import io.bosch.enterprisesystems.model.EnterpriseSystem;
import io.bosch.enterprisesystems.repository.EnterpriseSystemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class EnterpriseSystemServiceImplTest {
    @Mock
    private EnterpriseSystemRepository enterpriseSystemRepository;

    @InjectMocks
    EnterpriseSystemServiceImpl enterpriseSystemService;
    @Test
    public void testShouldSuccessfullyCreate() {

        //Given
        EnterpriseSystem enterpriseSystem =  EnterpriseSystem.builder().id(200L).build();
        EnterpriseSystem enterpriseSystemSave =  EnterpriseSystem.builder().build();
        when(enterpriseSystemRepository.save(enterpriseSystemSave)).thenReturn(enterpriseSystem);

        //When
        enterpriseSystemService.create(enterpriseSystemSave);

        //Then
        assertNotEquals(enterpriseSystem.getId(), enterpriseSystemSave.getId());
        verify(enterpriseSystemRepository, times(1)).save(enterpriseSystemSave);
    }

    @Test
    void testShouldSuccessfullyGetById() {
        //Given
        long id = 200L;
        EnterpriseSystem enterpriseSystem =  EnterpriseSystem.builder().id(id).build();
        when(enterpriseSystemRepository.getById(id)).thenReturn(enterpriseSystem);

        //When
        enterpriseSystemService.getById(id);

        //Then
        assertEquals(enterpriseSystem.getId(), id);
        verify(enterpriseSystemRepository, times(1)).findById(id);
    }

    @Test
    void testShouldSuccessfullySearch() {
    }

    @Test
    void testShouldSuccessfullyDelete() {
    }
}