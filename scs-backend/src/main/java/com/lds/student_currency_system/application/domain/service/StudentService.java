package com.lds.student_currency_system.application.domain.service;

import com.lds.student_currency_system.application.domain.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student save(Student student);

    Optional<Student> findById(Long id);

    List<Student> findAll();

    void deleteById(Long id);

    Student update(Student student);
}