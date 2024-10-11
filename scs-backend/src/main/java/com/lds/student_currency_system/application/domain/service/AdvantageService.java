package com.lds.student_currency_system.application.domain.service;

import com.lds.student_currency_system.application.domain.model.Advantage;

import java.util.List;
import java.util.Optional;

public interface AdvantageService {
    Advantage save(Advantage advantage);

    Optional<Advantage> findById(Long id);

    List<Advantage> findAll();

    void deleteById(Long id);

    Advantage update(Advantage advantage);
}