package com.lds.student_currency_system.domain.service;

import java.util.List;
import java.util.Optional;

import com.lds.student_currency_system.domain.model.Student;
import com.lds.student_currency_system.domain.model.Voucher;

public interface VoucherService {
    public Voucher createVoucher(Long idAdvantage, Student student);

    Optional<Voucher> findById(Long id);

    List<Voucher> findAll(Student student);

    List<Voucher> findAllActive(Student student);

    List<Voucher> findAllRedeemed(Student student);

    Voucher markAsUsed(Long idVoucher);

    void deleteById(Long id);

}