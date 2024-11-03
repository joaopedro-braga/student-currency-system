package com.lds.student_currency_system.domain.service;

import java.util.List;
import java.util.Optional;

import com.lds.student_currency_system.domain.model.Advantage;

public interface AdvantageService {
    Advantage save(Advantage advantage);

    Optional<Advantage> findById(Long id);

    List<Advantage> findAll();

    void deleteById(Long id);

    Advantage update(Advantage advantage);
}