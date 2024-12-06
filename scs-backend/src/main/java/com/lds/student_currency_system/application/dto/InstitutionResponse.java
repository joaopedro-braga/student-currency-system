package com.lds.student_currency_system.application.dto;

public record InstitutionResponse(
    Long id,
    String name,
    String email,
    String cnpj,
    String address
) {

}
