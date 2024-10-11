package com.lds.student_currency_system.application.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdminTest {

    @Test
    void testAdminCreation() {
        Admin admin = new Admin("Admin User", "admin@example.com", "adminpass");
        assertEquals("Admin User", admin.getName());
        assertEquals("admin@example.com", admin.getEmail());
        assertEquals("adminpass", admin.getPassword());
    }
}