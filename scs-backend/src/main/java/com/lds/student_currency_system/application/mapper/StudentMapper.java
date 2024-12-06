package com.lds.student_currency_system.application.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.lds.student_currency_system.application.dto.StudentRequest;
import com.lds.student_currency_system.application.dto.StudentResponse;
import com.lds.student_currency_system.domain.model.Institution;
import com.lds.student_currency_system.domain.model.Student;

@Component
public class StudentMapper {
    public static Student toStudent(StudentRequest request, Institution institution){
        if (request == null) {
            return null;
        }

        return new Student(request.name(), request.email(), new BCryptPasswordEncoder().encode(request.password()), request.cpf(), request.address(), institution, request.course(), 0);
    }

    public static StudentResponse toStudentResponse(Student student){
        if (student == null) {
            return null;
        }

        return new StudentResponse(student.getId(), student.getName(), student.getEmail(), student.getCpf(), student.getAddress(), student.getInstitution().getName(), student.getCourse());
    }

    public static List<StudentResponse> toStudentResponseList(List<Student> students) {
        return students.stream()
                .map(StudentMapper::toStudentResponse)
                .collect(Collectors.toList());
    }
}
