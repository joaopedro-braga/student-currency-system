package com.lds.student_currency_system.domain.service;

import java.util.List;
import java.util.Optional;

import com.lds.student_currency_system.domain.model.Transfer;

public interface TransferService {
    Transfer save(Transfer transfer);

    Optional<Transfer> findById(Long id);

    List<Transfer> findAll();

    void deleteById(Long id);

    Transfer update(Transfer transfer);
}