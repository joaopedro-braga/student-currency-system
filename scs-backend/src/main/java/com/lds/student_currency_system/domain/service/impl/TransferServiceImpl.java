package com.lds.student_currency_system.domain.service.impl;

import com.lds.student_currency_system.infra.repositories.TransferRepository;
import com.lds.student_currency_system.domain.model.Transfer;
import com.lds.student_currency_system.domain.service.TransferService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final TransferRepository transferRepository;

    @Override
    public Transfer save(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public Optional<Transfer> findById(Long id) {
        return transferRepository.findById(id);
    }

    @Override
    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        transferRepository.deleteById(id);
    }

    @Override
    public Transfer update(Transfer transfer) {
        if(transferRepository.existsById(transfer.getId())) {
            return transferRepository.save(transfer);
        }
        throw new RuntimeException("Transfer not found!");
    }
}