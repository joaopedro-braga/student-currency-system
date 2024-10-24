package com.lds.student_currency_system.application.domain.service;

import com.lds.student_currency_system.application.domain.model.Institution;
import com.lds.student_currency_system.application.domain.service.impl.InstitutionServiceImpl;
import com.lds.student_currency_system.application.infra.repositories.InstitutionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InstitutionServiceTest {

    @Mock
    private InstitutionRepository institutionRepository;

    @InjectMocks
    private InstitutionServiceImpl institutionService;

    @Test
    @DisplayName("Must save a new institution")
    void save() {
        Institution institution = new Institution();
        institution.setId(1L);
        institution.setName("Institution Test");
        // institution.setCnpj("12.345.678/0001-90");

        when(institutionRepository.save(any(Institution.class))).thenReturn(institution);

        Institution savedInstitution = institutionService.save(institution);

        assertNotNull(savedInstitution);
        assertEquals(institution.getId(), savedInstitution.getId());
        assertEquals(institution.getName(), savedInstitution.getName());
        // assertEquals(institution.getCnpj(), savedInstitution.getCnpj());

        verify(institutionRepository, times(1)).save(institution);
    }

    @Test
    @DisplayName("Must find an institution by id")
    void findById() {
        Long id = 1L;
        Institution institution = new Institution();
        institution.setId(id);
        institution.setName("Institution Test");
        // institution.setCnpj("12.345.678/0001-90");

        when(institutionRepository.findById(id)).thenReturn(Optional.of(institution));

        Optional<Institution> foundInstitution = institutionService.findById(id);

        assertTrue(foundInstitution.isPresent());
        assertEquals(institution.getId(), foundInstitution.get().getId());
        assertEquals(institution.getName(), foundInstitution.get().getName());
        // assertEquals(institution.getCnpj(), foundInstitution.get().getCnpj());

        verify(institutionRepository, times(1)).findById(id);
    }

    @Test
    @DisplayName("Must find all institutions")
    void findAll() {
        List<Institution> institutionList = new ArrayList<>();

        Institution institution1 = new Institution();
        institution1.setId(1L);
        institution1.setName("Institution 1");
        // institution1.setCnpj("12.345.678/0001-90");

        Institution institution2 = new Institution();
        institution2.setId(2L);
        institution2.setName("Institution 2");
        // institution2.setCnpj("98.765.432/0001-09");

        institutionList.add(institution1);
        institutionList.add(institution2);

        when(institutionRepository.findAll()).thenReturn(institutionList);

        List<Institution> foundInstitutions = institutionService.findAll();

        assertNotNull(foundInstitutions);
        assertEquals(2, foundInstitutions.size());

        verify(institutionRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Must delete an institution by id")
    void deleteById() {
        Long id = 1L;

        doNothing().when(institutionRepository).deleteById(id);

        institutionService.deleteById(id);

        verify(institutionRepository, times(1)).deleteById(id);
    }

    @Test
    @DisplayName("Must update an institution")
    void update() {
        Long id = 1L;
        Institution institution = new Institution();
        institution.setId(id);
        institution.setName("Institution Updated");
        // institution.setCnpj("12.345.678/0001-90");

        when(institutionRepository.existsById(id)).thenReturn(true);
        when(institutionRepository.save(any(Institution.class))).thenReturn(institution);

        Institution updatedInstitution = institutionService.update(institution);

        assertNotNull(updatedInstitution);
        assertEquals(institution.getId(), updatedInstitution.getId());
        assertEquals(institution.getName(), updatedInstitution.getName());
        // assertEquals(institution.getCnpj(), updatedInstitution.getCnpj());

        verify(institutionRepository, times(1)).existsById(id);
        verify(institutionRepository, times(1)).save(institution);
    }

    @Test
    @DisplayName("Must throw exception when trying to update an institution that does not exist")
    void updateNotFound() {
        Long id = 1L;
        Institution institution = new Institution();
        institution.setId(id);

        when(institutionRepository.existsById(id)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> institutionService.update(institution));

        verify(institutionRepository, times(1)).existsById(id);
        verify(institutionRepository, never()).save(institution);
    }
}