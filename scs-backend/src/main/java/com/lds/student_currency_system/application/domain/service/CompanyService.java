package com.lds.student_currency_system.application.domain.service;

import com.lds.student_currency_system.application.domain.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company save(Company company);

    Optional<Company> findById(Long id);

    List<Company> findAll();

    void deleteById(Long id);

    Company update(Company company);
}