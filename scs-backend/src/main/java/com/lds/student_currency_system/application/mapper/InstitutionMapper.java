package com.lds.student_currency_system.application.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.lds.student_currency_system.application.dto.InstitutionRequest;
import com.lds.student_currency_system.application.dto.InstitutionResponse;
import com.lds.student_currency_system.domain.model.Institution;

@Component
public class InstitutionMapper {
    public static Institution toInstitution(InstitutionRequest request){
        if (request == null) {
            return null;
        }

        return new Institution(request.name(), request.email(), new BCryptPasswordEncoder().encode((request.cnpj())), request.cnpj(), request.address());
    }

    public static InstitutionResponse toInstitutionResponse(Institution institution){
        if (institution == null) {
            return null;
        }

        return new InstitutionResponse(institution.getId(), institution.getName(), institution.getEmail(), institution.getCnpj(), institution.getAddress());
    }

    public static List<InstitutionResponse> toInstitutionResponseList(List<Institution> institutions) {
    return institutions.stream()
            .map(InstitutionMapper::toInstitutionResponse) 
            .collect(Collectors.toList());  
    }
}
