package com.lds.student_currency_system.application.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lds.student_currency_system.application.dto.StudentRequest;
import com.lds.student_currency_system.application.dto.StudentResponse;
import com.lds.student_currency_system.domain.model.Student;
import com.lds.student_currency_system.domain.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Long id) {
        return studentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        List<StudentResponse> students = studentService.findAll();
        return ResponseEntity.ok(students);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateStudent(@PathVariable Long id, @RequestBody StudentRequest request) {
        StudentResponse updatedStudent = studentService.update(id, request);
        return ResponseEntity.ok(updatedStudent);
    }

    @GetMapping("/balance")
    public ResponseEntity<Float> getUserBalance(@AuthenticationPrincipal Student student) {
        Student updateStudent = studentService.findByUsername(student.getUsername());
        return ResponseEntity.ok(updateStudent.getBalance());
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteStudent(@AuthenticationPrincipal Student student) {
        studentService.deleteById(student.getId());
        return ResponseEntity.noContent().build();
    }
}