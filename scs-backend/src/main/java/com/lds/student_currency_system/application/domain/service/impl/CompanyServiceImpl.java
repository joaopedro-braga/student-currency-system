package com.lds.student_currency_system.application.domain.service.impl;

import com.lds.student_currency_system.application.domain.model.Company;
import com.lds.student_currency_system.application.domain.service.CompanyService;
import com.lds.student_currency_system.application.infra.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Company update(Company company) {
        if(companyRepository.existsById(company.getId())) {
            return companyRepository.save(company);
        }
        throw new RuntimeException("Company not found!");
    }
}