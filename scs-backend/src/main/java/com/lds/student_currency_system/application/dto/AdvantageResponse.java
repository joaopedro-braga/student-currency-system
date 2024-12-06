package com.lds.student_currency_system.application.dto;

import java.time.LocalDateTime;

public record AdvantageResponse(
        Long id,
        String name,
        String image,
        float price,
        String institution,
        String description,
        LocalDateTime date) {
}
