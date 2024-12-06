package com.lds.student_currency_system.application.dto;

import java.sql.Date;

import com.lds.student_currency_system.domain.enums.VoucherStatus;

public record VoucherResponse(
    String title, 
    String description,
    String image,
    String code,
    String qrCode,
    String company,
    Date validity,
    VoucherStatus status
) {
}

