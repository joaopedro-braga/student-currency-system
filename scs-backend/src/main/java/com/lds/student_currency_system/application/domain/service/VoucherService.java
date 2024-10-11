package com.lds.student_currency_system.application.domain.service;

import com.lds.student_currency_system.application.domain.model.Voucher;

import java.util.List;
import java.util.Optional;

public interface VoucherService {
    Voucher save(Voucher voucher);

    Optional<Voucher> findById(Long id);

    List<Voucher> findAll();

    void deleteById(Long id);

    Voucher update(Voucher voucher);
}