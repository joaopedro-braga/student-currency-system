package com.lds.student_currency_system.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompanyTest {

    @Test
    void testCompanyCreation() {
        Company company = new Company("Company Name", "company@example.com", "companypass", "12345678901234", "Company Address");
        assertEquals("Company Name", company.getName());
        assertEquals("company@example.com", company.getEmail());
        assertEquals("companypass", company.getPassword());
        assertEquals("12345678901234", company.getCnpj());
        assertEquals("Company Address", company.getAddress());
    }
}