package com.lds.student_currency_system.application.domain.service;

import com.lds.student_currency_system.application.domain.model.Institution;

import java.util.List;
import java.util.Optional;

public interface InstitutionService {
    Institution save(Institution institution);

    Optional<Institution> findById(Long id);

    List<Institution> findAll();

    void deleteById(Long id);

    Institution update(Institution institution);
}