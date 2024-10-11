package com.lds.student_currency_system.application.domain.service;

import com.lds.student_currency_system.application.domain.model.Transfer;

import java.util.List;
import java.util.Optional;

public interface TransferService {
    Transfer save(Transfer transfer);

    Optional<Transfer> findById(Long id);

    List<Transfer> findAll();

    void deleteById(Long id);

    Transfer update(Transfer transfer);
}