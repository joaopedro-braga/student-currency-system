package com.lds.student_currency_system.application.dto;

public record TransferRequest(
    Long receiverId,
    float coinQuantity,
    String description
) {
}
