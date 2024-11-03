package com.lds.student_currency_system.application.mapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.lds.student_currency_system.application.dto.RegisterCompanyRequest;
import com.lds.student_currency_system.domain.model.Company;

public class CompanyMapper {
    public static Company toCompany(RegisterCompanyRequest request){
        if (request == null) {
            return null;
        }
        
        return new Company(request.name(), request.email(), new BCryptPasswordEncoder().encode(request.password()), request.cnpj(), request.address());
    }
}
