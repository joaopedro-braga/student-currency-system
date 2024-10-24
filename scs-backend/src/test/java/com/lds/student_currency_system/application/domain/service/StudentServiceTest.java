package com.lds.student_currency_system.application.domain.service;

import com.lds.student_currency_system.application.domain.model.Student;
import com.lds.student_currency_system.application.domain.service.impl.StudentServiceImpl;
import com.lds.student_currency_system.application.infra.repositories.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Test
    @DisplayName("Should save a new student")
    void save() {
        Student student = new Student();
        student.setId(1L);
        student.setName("Student Test");

        when(studentRepository.save(any(Student.class))).thenReturn(student);

        Student savedStudent = studentService.save(student);

        assertNotNull(savedStudent);
        assertEquals(student.getId(), savedStudent.getId());
        assertEquals(student.getName(), savedStudent.getName());

        verify(studentRepository, times(1)).save(student);
    }

    @Test
    @DisplayName("Should find a student by id")
    void findById() {
        Long id = 1L;
        Student student = new Student();
        student.setId(id);
        student.setName("Student Test");

        when(studentRepository.findById(id)).thenReturn(Optional.of(student));

        Optional<Student> foundStudent = studentService.findById(id);

        assertTrue(foundStudent.isPresent());
        assertEquals(student.getId(), foundStudent.get().getId());
        assertEquals(student.getName(), foundStudent.get().getName());

        verify(studentRepository, times(1)).findById(id);
    }

    @Test
    @DisplayName("Should find all students")
    void findAll() {
        List<Student> studentList = new ArrayList<>();

        Student student1 = new Student();
        student1.setId(1L);
        student1.setName("Student 1");

        Student student2 = new Student();
        student2.setId(2L);
        student2.setName("Student 2");

        studentList.add(student1);
        studentList.add(student2);

        when(studentRepository.findAll()).thenReturn(studentList);

        List<Student> foundStudents = studentService.findAll();

        assertNotNull(foundStudents);
        assertEquals(2, foundStudents.size());

        verify(studentRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should delete a student by id")
    void deleteById() {
        Long id = 1L;

        doNothing().when(studentRepository).deleteById(id);

        studentService.deleteById(id);

        verify(studentRepository, times(1)).deleteById(id);
    }

    @Test
    @DisplayName("Should update a student")
    void update() {
        Long id = 1L;
        Student student = new Student();
        student.setId(id);
        student.setName("Student Test Updated");

        when(studentRepository.existsById(id)).thenReturn(true);
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        Student updatedStudent = studentService.update(student);

        assertNotNull(updatedStudent);
        assertEquals(student.getId(), updatedStudent.getId());
        assertEquals(student.getName(), updatedStudent.getName());

        verify(studentRepository, times(1)).existsById(id);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    @DisplayName("Should throw exception when trying to update a student that does not exist")
    void updateNotFound() {
        Long id = 1L;
        Student student = new Student();
        student.setId(id);
        student.setName("Student Test Updated");

        when(studentRepository.existsById(id)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> studentService.update(student));

        verify(studentRepository, times(1)).existsById(id);
        verify(studentRepository, never()).save(student);
    }
}