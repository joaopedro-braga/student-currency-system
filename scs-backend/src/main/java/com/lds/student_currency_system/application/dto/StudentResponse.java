package com.lds.student_currency_system.application.dto;

public record StudentResponse(
    Long id,
    String name,
    String email,
    String cpf,
    String address,
    String institution,
    String course
) {
    
}
