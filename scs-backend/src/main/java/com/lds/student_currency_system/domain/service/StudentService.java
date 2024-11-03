package com.lds.student_currency_system.domain.service;

import java.util.List;
import java.util.Optional;

import com.lds.student_currency_system.domain.model.Student;

public interface StudentService {
    Student save(Student student);

    Optional<Student> findById(Long id);

    List<Student> findAll();

    void deleteById(Long id);

    Student update(Student student);
}