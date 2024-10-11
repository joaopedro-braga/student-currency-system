package com.lds.student_currency_system.application.infra.repositories;

import com.lds.student_currency_system.application.domain.model.Institution;
import com.lds.student_currency_system.application.domain.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private InstitutionRepository institutionRepository;

    @Test
    void testSaveAndFindStudent() {
        Institution institution = new Institution("Test University");
        institutionRepository.save(institution);

        Student student = new Student("Student Name", "student@example.com", "studentpass", "98765432101", "Address", institution, "Computer Science", 50.0f);
        studentRepository.save(student);

        Student foundStudent = studentRepository.findById(student.getId()).orElse(null);

        assertNotNull(foundStudent);
        assertEquals("Student Name", foundStudent.getName());
    }
}