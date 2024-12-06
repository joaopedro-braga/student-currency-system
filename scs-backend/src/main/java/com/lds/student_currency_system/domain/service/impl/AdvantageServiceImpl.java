package com.lds.student_currency_system.domain.service.impl;

import com.lds.student_currency_system.infra.repositories.AdvantageRepository;
import com.lds.student_currency_system.infra.repositories.CompanyRepository;
import com.lds.student_currency_system.application.dto.AdvantageRequest;
import com.lds.student_currency_system.application.dto.AdvantageResponse;
import com.lds.student_currency_system.application.mapper.AdvantageMapper;
import com.lds.student_currency_system.domain.model.Advantage;
import com.lds.student_currency_system.domain.model.Company;
import com.lds.student_currency_system.domain.service.AdvantageService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdvantageServiceImpl implements AdvantageService {

    private final AdvantageRepository advantageRepository;
    private final CompanyRepository companyRepository;

    @Override
    public AdvantageResponse save(AdvantageRequest advantageRequest) {
        Company company = companyRepository.findById(advantageRequest.companyId())
                .orElseThrow(() -> new RuntimeException("Company not found!"));

        Advantage advantage = AdvantageMapper.toAdvantage(advantageRequest, company);
        return AdvantageMapper.toAdvantageResponse(advantageRepository.save(advantage));
    }

    @Override
    public Optional<AdvantageResponse> findById(Long id) {
        Optional<Advantage> advantage = advantageRepository.findById(id);

        if (advantage.isPresent()) {
            return Optional.of(AdvantageMapper.toAdvantageResponse(advantage.get()));
        }

        return Optional.empty();
    }

    @Override
    public List<AdvantageResponse> findAll() {
        List<Advantage> advantages = advantageRepository.findAll();
        return AdvantageMapper.toAdvantageResponseList(advantages);
    }

    @Override
    public void deleteById(Long id) {
        advantageRepository.deleteById(id);
    }

    @Override
    public AdvantageResponse update(Long id, AdvantageRequest advantageRequest) {
        Company company = companyRepository.findById(advantageRequest.companyId())
                .orElseThrow(() -> new RuntimeException("Company not found!"));

        Advantage advantage = AdvantageMapper.toAdvantage(advantageRequest, company);

        advantage.setId(id);

        if (advantageRepository.existsById(advantage.getId())) {
            advantage = advantageRepository.save(advantage);
            return AdvantageMapper.toAdvantageResponse(advantage);
        }
        throw new RuntimeException("Advantage not found!");
    }

    @Override
    public List<AdvantageResponse> findAllByCompany(Company company) {
        List<Advantage> advantages = advantageRepository.findAllByCompany(company);
        return AdvantageMapper.toAdvantageResponseList(advantages);
    }
}