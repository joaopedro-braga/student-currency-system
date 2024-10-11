package com.lds.student_currency_system.application.infra.repositories;

import com.lds.student_currency_system.application.domain.model.Advantage;
import com.lds.student_currency_system.application.domain.model.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class AdvantageRepositoryTest {

    @Autowired
    private AdvantageRepository advantageRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @Test
    void testSaveAndFindAdvantage() {
        Company company = new Company("Company Name", "company@example.com", "companypass", "12345678901234", "Company Address");
        companyRepository.save(company);

        Advantage advantage = new Advantage("Discount", "image.jpg", 25.0f, company, "10% off", new Date());
        advantageRepository.save(advantage);

        Advantage foundAdvantage = advantageRepository.findById(advantage.getId()).orElse(null);

        assertNotNull(foundAdvantage);
        assertEquals("Discount", foundAdvantage.getName());
    }
}