package com.lds.student_currency_system.domain.service;

import java.util.List;
import java.util.Optional;

import com.lds.student_currency_system.domain.model.Voucher;

public interface VoucherService {
    Voucher save(Voucher voucher);

    Optional<Voucher> findById(Long id);

    List<Voucher> findAll();

    void deleteById(Long id);

    Voucher update(Voucher voucher);
}