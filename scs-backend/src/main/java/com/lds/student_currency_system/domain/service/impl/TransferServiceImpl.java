package com.lds.student_currency_system.domain.service.impl;

import com.lds.student_currency_system.infra.repositories.TransferRepository;
import com.lds.student_currency_system.application.dto.TransferResponse;
import com.lds.student_currency_system.application.mapper.TransferMapper;
import com.lds.student_currency_system.domain.model.Transfer;
import com.lds.student_currency_system.domain.model.User;
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
    public Optional<TransferResponse> findById(Long id) {
        Optional<Transfer> transferOpt = transferRepository.findById(id);

        if (transferOpt.isPresent()) {
            TransferResponse response = TransferMapper.toTransferResponse(transferOpt.get(), id);
            return Optional.of(response);
        }

        return Optional.empty();
    }

    @Override
    public List<TransferResponse> findAllByTransactor(User user) {
        List<Transfer> transfers = transferRepository.findAllByReceiverIdOrSenderId(user.getId(), user.getId());
        return TransferMapper.toTransferResponseList(transfers, user.getId());
    }

    @Override
    public List<TransferResponse> findAll() {
        List<Transfer> transfers = transferRepository.findAll();
        return TransferMapper.toTransferResponseList(transfers, null);
    }

}