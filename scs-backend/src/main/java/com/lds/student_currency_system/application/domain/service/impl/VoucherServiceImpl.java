package com.lds.student_currency_system.application.domain.service.impl;

import com.lds.student_currency_system.application.domain.model.Voucher;
import com.lds.student_currency_system.application.domain.service.VoucherService;
import com.lds.student_currency_system.application.infra.repositories.VoucherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VoucherServiceImpl implements VoucherService {

    private final VoucherRepository voucherRepository;

    @Override
    public Voucher save(Voucher voucher) {
        return voucherRepository.save(voucher);
    }

    @Override
    public Optional<Voucher> findById(Long id) {
        return voucherRepository.findById(id);
    }

    @Override
    public List<Voucher> findAll() {
        return voucherRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        voucherRepository.deleteById(id);
    }

    @Override
    public Voucher update(Voucher voucher) {
        if(voucherRepository.existsById(voucher.getId())) {
            return voucherRepository.save(voucher);
        }
        throw new RuntimeException("Voucher not found!");
    }
}