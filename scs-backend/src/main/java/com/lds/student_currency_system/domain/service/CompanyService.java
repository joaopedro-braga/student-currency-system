package com.lds.student_currency_system.domain.service;

import java.util.List;
import java.util.Optional;

import com.lds.student_currency_system.application.dto.CompanyRequest;
import com.lds.student_currency_system.application.dto.CompanyResponse;
import com.lds.student_currency_system.domain.model.Company;

public interface CompanyService {
    Company save(CompanyRequest company);

    Optional<CompanyResponse> findById(Long id);

    Optional<Company> findByEmail(String cnpj);

    List<CompanyResponse> findAll();

    void deleteById(Long id);

    CompanyResponse update(Long id, CompanyRequest company);
}