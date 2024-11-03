package com.lds.student_currency_system.domain.service.impl;

import com.lds.student_currency_system.infra.repositories.StudentRepository;
import com.lds.student_currency_system.domain.model.Student;
import com.lds.student_currency_system.domain.service.StudentService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student update(Student student) {
        if(studentRepository.existsById(student.getId())) {
            return studentRepository.save(student);
        }
        throw new RuntimeException("Student not found!");
    }
}