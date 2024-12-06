package com.lds.student_currency_system.application.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.lds.student_currency_system.application.dto.CompanyRequest;
import com.lds.student_currency_system.application.dto.CompanyResponse;
import com.lds.student_currency_system.domain.model.Company;

@Component
public class CompanyMapper {
    public static Company toCompany(CompanyRequest request){
        if (request == null) {
            return null;
        }
        
        return new Company(request.name(), request.email(), new BCryptPasswordEncoder().encode(request.password()), request.cnpj(), request.address());
    }

    public static CompanyResponse toCompanyResponse(Company company){
        if (company == null) {
            return null;
        }

        return new CompanyResponse(company.getId(), company.getName(), company.getEmail(), company.getCnpj(), company.getAddress());
    }

    public static List<CompanyResponse> toCompanyResponseList(List<Company> companies) {
        return companies.stream()
                .map(CompanyMapper::toCompanyResponse)
                .collect(Collectors.toList());
    }
}
