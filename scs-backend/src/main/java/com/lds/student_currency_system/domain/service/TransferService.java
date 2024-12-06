package com.lds.student_currency_system.domain.service;

import java.util.List;
import java.util.Optional;

import com.lds.student_currency_system.application.dto.TransferResponse;
import com.lds.student_currency_system.domain.model.User;

public interface TransferService {

    Optional<TransferResponse> findById(Long id);

    List<TransferResponse> findAllByTransactor(User user);

    List<TransferResponse> findAll();
}