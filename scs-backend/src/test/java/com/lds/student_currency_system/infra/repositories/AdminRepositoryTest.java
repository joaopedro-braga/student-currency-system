package com.lds.student_currency_system.infra.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.lds.student_currency_system.domain.model.Admin;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class AdminRepositoryTest {

    @Autowired
    private AdminRepository adminRepository;

    @Test
    void testSaveAndFindAdmin() {
        Admin admin = new Admin("Admin User", "admin@example.com", "adminpass");
        adminRepository.save(admin);

        Admin foundAdmin = adminRepository.findById(admin.getId()).orElse(null);

        assertNotNull(foundAdmin);
        assertEquals("Admin User", foundAdmin.getName());
    }
}