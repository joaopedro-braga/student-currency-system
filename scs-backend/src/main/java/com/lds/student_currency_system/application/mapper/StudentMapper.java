package com.lds.student_currency_system.application.mapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.lds.student_currency_system.application.dto.RegisterStudentRequest;
import com.lds.student_currency_system.domain.model.Student;

public class StudentMapper {
    public static Student toStudent(RegisterStudentRequest request){
        if (request == null) {
            return null;
        }

        return new Student(request.name(), request.email(), new BCryptPasswordEncoder().encode(request.password()), request.cpf(), request.address(), request.institution(), request.course(), 0);
    }
}
