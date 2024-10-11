package com.lds.student_currency_system.application.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InstitutionTest {

    @Test
    void testInstitutionCreation() {
        Institution institution = new Institution("University");
        assertEquals("University", institution.getName());
    }
}