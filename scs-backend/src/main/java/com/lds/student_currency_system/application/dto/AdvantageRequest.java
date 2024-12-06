package com.lds.student_currency_system.application.dto;

public record AdvantageRequest(
    String name, 
    String image,
    float price, 
    Long companyId,
    String description) {
}
