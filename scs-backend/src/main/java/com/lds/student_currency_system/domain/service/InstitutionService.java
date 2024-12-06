package com.lds.student_currency_system.domain.service;

import java.util.List;
import java.util.Optional;

import com.lds.student_currency_system.application.dto.InstitutionRequest;
import com.lds.student_currency_system.application.dto.InstitutionResponse;


public interface InstitutionService {
    InstitutionResponse save(InstitutionRequest institution);

    Optional<InstitutionResponse> findById(Long id);

    List<InstitutionResponse> findAll();

    void deleteById(Long id);

    InstitutionResponse update(Long id, InstitutionRequest institution);
}