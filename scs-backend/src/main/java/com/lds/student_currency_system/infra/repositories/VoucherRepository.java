package com.lds.student_currency_system.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lds.student_currency_system.domain.model.Voucher;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Long> {
}