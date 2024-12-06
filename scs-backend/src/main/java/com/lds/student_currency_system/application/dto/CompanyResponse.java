package com.lds.student_currency_system.application.dto;

public record CompanyResponse(
    Long id,
    String name,
    String email,
    String cnpj,
    String address
) {
    
}
