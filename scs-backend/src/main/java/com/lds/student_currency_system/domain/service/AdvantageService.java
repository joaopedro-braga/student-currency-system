package com.lds.student_currency_system.domain.service;

import java.util.List;
import java.util.Optional;

import com.lds.student_currency_system.application.dto.AdvantageRequest;
import com.lds.student_currency_system.application.dto.AdvantageResponse;
import com.lds.student_currency_system.domain.model.Company;

public interface AdvantageService {
    AdvantageResponse save(AdvantageRequest advantage);

    Optional<AdvantageResponse> findById(Long id);

    List<AdvantageResponse> findAll();

    void deleteById(Long id);

    AdvantageResponse update(Long id, AdvantageRequest advantage);

    List<AdvantageResponse> findAllByCompany(Company company);

}