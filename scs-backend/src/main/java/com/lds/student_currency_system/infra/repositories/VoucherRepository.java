package com.lds.student_currency_system.infra.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lds.student_currency_system.domain.enums.VoucherStatus;
import com.lds.student_currency_system.domain.model.Voucher;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    List<Voucher> findAllByStudentId(Long studentId);
    List<Voucher> findAllByStudentIdAndStatusAndValidityAfter(Long studentId, VoucherStatus status, Date validity);
    List<Voucher> findByStudentIdAndStatusOrValidityBefore(Long studentId, VoucherStatus status, Date validity);
}