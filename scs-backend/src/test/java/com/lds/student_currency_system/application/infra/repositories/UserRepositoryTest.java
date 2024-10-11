package com.lds.student_currency_system.application.infra.repositories;

import com.lds.student_currency_system.application.domain.model.Institution;
import com.lds.student_currency_system.application.domain.model.Professor;
import com.lds.student_currency_system.application.domain.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByEmail() {
        Professor professor = new Professor("Test Professor", "test@example.com", "password", "12345678901", "Department", new Institution("Institution name"), 100.0f);
        userRepository.save(professor);

        Optional<User> foundUser = userRepository.findByEmail("test@example.com");
        assertTrue(foundUser.isPresent());
        assertEquals(professor.getId(), foundUser.get().getId());
    }
}