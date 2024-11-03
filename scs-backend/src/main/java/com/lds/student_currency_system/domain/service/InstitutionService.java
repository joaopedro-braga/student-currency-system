package com.lds.student_currency_system.domain.service;

import java.util.List;
import java.util.Optional;

import com.lds.student_currency_system.domain.model.Institution;

public interface InstitutionService {
    Institution save(Institution institution);

    Optional<Institution> findById(Long id);

    List<Institution> findAll();

    void deleteById(Long id);

    Institution update(Institution institution);
}