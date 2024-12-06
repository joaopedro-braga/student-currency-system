package com.lds.student_currency_system.application.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.lds.student_currency_system.application.dto.TransferResponse;
import com.lds.student_currency_system.domain.enums.TransferType;
import com.lds.student_currency_system.domain.model.Transfer;
import com.lds.student_currency_system.domain.model.User;

@Component
public class TransferMapper {
    public static Transfer toTransfer(User sender, User receiver, float coinQuantity, String description) {        
        return new Transfer(sender, receiver, coinQuantity, description);
    }

    public static TransferResponse toTransferResponse(Transfer transfer, Long userId) {
        if (transfer == null) {
            return null;
        }

        TransferType type = (transfer.getSender().getId().equals(userId)) ? TransferType.DEBIT : TransferType.CREDIT;
        String transactor = (type == TransferType.DEBIT) ? transfer.getReceiver().getName() : transfer.getSender().getName();

        return new TransferResponse(transfer.getId(), transfer.getDate(), transactor, transfer.getCoinQuantity(), type, transfer.getDescription());
    }

    public static List<TransferResponse> toTransferResponseList(List<Transfer> transfers, Long userId) {
        return transfers.stream()
                .map(transfer -> toTransferResponse(transfer, userId))
                .collect(Collectors.toList());
    }
}
