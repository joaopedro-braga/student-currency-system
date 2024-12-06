package com.lds.student_currency_system.application.mapper;

import com.lds.student_currency_system.application.dto.ProfessorRequest;
import com.lds.student_currency_system.application.dto.ProfessorResponse;
import com.lds.student_currency_system.domain.model.Institution;
import com.lds.student_currency_system.domain.model.Professor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {
    public static Professor toProfessor(ProfessorRequest request, Institution institution){
        if (request == null) {
            return null;
        }
       return new Professor(
                request.name(),
                request.email(),
                new BCryptPasswordEncoder().encode(request.cpf()),
                request.cpf(),
                request.department(),
                institution,
                1000.0f 
        );
    }

    public static ProfessorResponse toProfessorResponse(Professor professor){
        if (professor == null) {
            return null;
        }

        return new ProfessorResponse(
                professor.getId(),
                professor.getName(),
                professor.getEmail(),
                professor.getCpf(),
                professor.getInstitution().getName(),
                professor.getDepartment(),
                professor.getBalance()
        );
    }

    public static List<ProfessorResponse> toProfessorResponseList(List<Professor> professors) {
        return professors.stream()
                .map(ProfessorMapper::toProfessorResponse)
                .collect(Collectors.toList());
    }
}
