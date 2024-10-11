package com.lds.student_currency_system.application.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    @Test
    void testStudentCreation() {
        Institution institution = new Institution("University");
        Student student = new Student("Student Name", "student@example.com", "studentpass", "98765432101", "Address", institution, "Computer Science", 50.0f);
        assertEquals("Student Name", student.getName());
        assertEquals("student@example.com", student.getEmail());
        assertEquals("studentpass", student.getPassword());
        assertEquals("98765432101", student.getCpf());
        assertEquals("Address", student.getAddress());
        assertEquals(institution, student.getInstitution());
        assertEquals("Computer Science", student.getCourse());
        assertEquals(50.0f, student.getBalance());
    }
}
