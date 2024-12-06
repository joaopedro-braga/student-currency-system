package com.lds.student_currency_system.domain.service;

import java.util.List;
import java.util.Optional;

import com.lds.student_currency_system.application.dto.StudentRequest;
import com.lds.student_currency_system.application.dto.StudentResponse;
import com.lds.student_currency_system.domain.model.Student;

public interface StudentService {
    Student save(StudentRequest request);

    Optional<StudentResponse> findById(Long id);

    List<StudentResponse> findAll();

    void deleteById(Long id);

    Student findByUsername(String username);

    StudentResponse update(Long id, StudentRequest student);
}