package com.lds.student_currency_system.application.dto;

import java.time.LocalDateTime;

import com.lds.student_currency_system.domain.enums.TransferType;

public record TransferResponse(
    Long id,
    LocalDateTime date,
    String transactor,
    float coinQuantity,
    TransferType type,
    String description
) {
    
}
