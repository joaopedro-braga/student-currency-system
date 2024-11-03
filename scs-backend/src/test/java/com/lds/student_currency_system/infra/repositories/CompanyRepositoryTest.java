package com.lds.student_currency_system.infra.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.lds.student_currency_system.domain.model.Company;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    void testSaveAndFindCompany() {
        Company company = new Company("Company Name", "company@example.com", "companypass", "12345678901234", "Company Address");
        companyRepository.save(company);

        Company foundCompany = companyRepository.findById(company.getId()).orElse(null);

        assertNotNull(foundCompany);
        assertEquals("Company Name", foundCompany.getName());
    }
}