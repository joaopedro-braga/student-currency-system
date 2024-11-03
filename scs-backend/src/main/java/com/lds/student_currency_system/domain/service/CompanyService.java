package com.lds.student_currency_system.domain.service;

import java.util.List;
import java.util.Optional;

import com.lds.student_currency_system.domain.model.Company;

public interface CompanyService {
    Company save(Company company);

    Optional<Company> findById(Long id);

    List<Company> findAll();

    void deleteById(Long id);

    Company update(Company company);
}