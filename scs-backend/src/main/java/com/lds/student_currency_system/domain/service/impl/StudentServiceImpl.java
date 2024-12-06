package com.lds.student_currency_system.domain.service.impl;

import com.lds.student_currency_system.infra.repositories.InstitutionRepository;
import com.lds.student_currency_system.infra.repositories.StudentRepository;
import com.lds.student_currency_system.application.dto.StudentRequest;
import com.lds.student_currency_system.application.dto.StudentResponse;
import com.lds.student_currency_system.application.mapper.StudentMapper;
import com.lds.student_currency_system.domain.model.Institution;
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
    private final InstitutionRepository institutionRepository;

    @Override
    public Student save(StudentRequest studentRequest) {
        Institution institution = institutionRepository.findById(studentRequest.institutionId())
                .orElseThrow(() -> new RuntimeException("Institution not found!"));

        if(studentRepository.existsByEmail(studentRequest.email()))
            throw new RuntimeException("Email already in use!");

        Student student = StudentMapper.toStudent(studentRequest, institution);
        return studentRepository.save(student);
    }

    @Override
    public Optional<StudentResponse> findById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found!"));
        
        return Optional.of(StudentMapper.toStudentResponse(student));
    }

    @Override
    public Student findByUsername(String username) {
        return studentRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("Student not found!"));
    }

    @Override
    public List<StudentResponse> findAll() {
        return StudentMapper.toStudentResponseList(studentRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponse update(Long id, StudentRequest studentRequest) {
        Institution institution = institutionRepository.findById(studentRequest.institutionId())
                .orElseThrow(() -> new RuntimeException("Institution not found!"));

        Student student = StudentMapper.toStudent(studentRequest, institution);
        student.setId(id);

        if(studentRepository.existsById(student.getId())) {
            return StudentMapper.toStudentResponse(studentRepository.save(student));
        }
        throw new RuntimeException("Student not found!");
    }
}