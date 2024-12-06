package com.lds.student_currency_system.domain.service.impl;

import com.lds.student_currency_system.infra.repositories.CompanyRepository;
import com.lds.student_currency_system.application.dto.CompanyRequest;
import com.lds.student_currency_system.application.dto.CompanyResponse;
import com.lds.student_currency_system.application.mapper.CompanyMapper;
import com.lds.student_currency_system.domain.model.Company;
import com.lds.student_currency_system.domain.service.CompanyService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public Company save(CompanyRequest companyRequest) {
        if(companyRepository.existsByEmail(companyRequest.email()))
            throw new RuntimeException("Email already in use!");

        Company company = CompanyMapper.toCompany(companyRequest);
        return companyRepository.save(company);
    }

    @Override
    public Optional<CompanyResponse> findById(Long id) {

        if (companyRepository.existsById(id)) {
            Company company = companyRepository.findById(id).get();
            return Optional.of(CompanyMapper.toCompanyResponse(company));
        }

        return Optional.empty();
    }

    @Override
    public List<CompanyResponse> findAll() {
        List<Company> companies = companyRepository.findAll();
        return CompanyMapper.toCompanyResponseList(companies);
    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Optional<Company> findByEmail(String email) {
        if (companyRepository.existsByEmail(email)) {
            return Optional.of(companyRepository.findByEmail(email).get());
        }

        return Optional.empty();
    }

    @Override
    public CompanyResponse update(Long id, CompanyRequest companyRequest) {
        Company company = CompanyMapper.toCompany(companyRequest);
        company.setId(id);
        if(companyRepository.existsById(company.getId())) {
            company = companyRepository.save(company);
            return CompanyMapper.toCompanyResponse(company);
        }
        throw new RuntimeException("Company not found!");
    }
}