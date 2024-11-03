package com.lds.student_currency_system.domain.service;

import com.lds.student_currency_system.infra.repositories.CompanyRepository;
import com.lds.student_currency_system.domain.model.Company;
import com.lds.student_currency_system.domain.service.impl.CompanyServiceImpl;

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
class CompanyServiceTest {

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyServiceImpl companyService;

    @Test
    @DisplayName("Must save a new company")
    void save() {
        Company company = new Company();
        company.setId(1L);
        company.setName("Company Test");
        company.setCnpj("12.345.678/0001-90");

        when(companyRepository.save(any(Company.class))).thenReturn(company);

        Company savedCompany = companyService.save(company);

        assertNotNull(savedCompany);
        assertEquals(company.getId(), savedCompany.getId());
        assertEquals(company.getName(), savedCompany.getName());
        assertEquals(company.getCnpj(), savedCompany.getCnpj());

        verify(companyRepository, times(1)).save(company);
    }

    @Test
    @DisplayName("Must find a company by id")
    void findById() {
        Long id = 1L;
        Company company = new Company();
        company.setId(id);
        company.setName("Company Test");
        company.setCnpj("12.345.678/0001-90");

        when(companyRepository.findById(id)).thenReturn(Optional.of(company));

        Optional<Company> foundCompany = companyService.findById(id);

        assertTrue(foundCompany.isPresent());
        assertEquals(company.getId(), foundCompany.get().getId());
        assertEquals(company.getName(), foundCompany.get().getName());
        assertEquals(company.getCnpj(), foundCompany.get().getCnpj());

        verify(companyRepository, times(1)).findById(id);
    }

    @Test
    @DisplayName("Must find all companies")
    void findAll() {
        List<Company> companyList = new ArrayList<>();

        Company company1 = new Company();
        company1.setId(1L);
        company1.setName("Company 1");
        company1.setCnpj("12.345.678/0001-90");

        Company company2 = new Company();
        company2.setId(2L);
        company2.setName("Company 2");
        company2.setCnpj("98.765.432/0001-09");

        companyList.add(company1);
        companyList.add(company2);

        when(companyRepository.findAll()).thenReturn(companyList);

        List<Company> foundCompanies = companyService.findAll();

        assertNotNull(foundCompanies);
        assertEquals(2, foundCompanies.size());

        verify(companyRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Must delete a company by id")
    void deleteById() {
        Long id = 1L;

        doNothing().when(companyRepository).deleteById(id);

        companyService.deleteById(id);

        verify(companyRepository, times(1)).deleteById(id);
    }

    @Test
    @DisplayName("Must update a company")
    void update() {
        Long id = 1L;
        Company company = new Company();
        company.setId(id);
        company.setName("Company Updated");
        company.setCnpj("12.345.678/0001-90");

        when(companyRepository.existsById(id)).thenReturn(true);
        when(companyRepository.save(any(Company.class))).thenReturn(company);

        Company updatedCompany = companyService.update(company);

        assertNotNull(updatedCompany);
        assertEquals(company.getId(), updatedCompany.getId());
        assertEquals(company.getName(), updatedCompany.getName());
        assertEquals(company.getCnpj(), updatedCompany.getCnpj());

        verify(companyRepository, times(1)).existsById(id);
        verify(companyRepository, times(1)).save(company);
    }

    @Test
    @DisplayName("Must throw exception when trying to update a company that does not exist")
    void updateNotFound() {
        Long id = 1L;
        Company company = new Company();
        company.setId(id);

        when(companyRepository.existsById(id)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> companyService.update(company));

        verify(companyRepository, times(1)).existsById(id);
        verify(companyRepository, never()).save(company);
    }
}