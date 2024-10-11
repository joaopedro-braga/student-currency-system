package com.lds.student_currency_system.application.domain.model;

import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdvantageTest {

    @Test
    void testAdvantageCreation() {
        Company company = new Company("Company Name", "company@example.com", "companypass", "12345678901234", "Company Address");
        Date date = new Date();
        Advantage advantage = new Advantage("Discount", "image.jpg", 25.0f, company, "10% off", date);
        assertEquals("Discount", advantage.getName());
        assertEquals("image.jpg", advantage.getImage());
        assertEquals(25.0f, advantage.getValue());
        assertEquals(company, advantage.getCompany());
        assertEquals("10% off", advantage.getDescription());
        assertEquals(date, advantage.getDate());
    }
}