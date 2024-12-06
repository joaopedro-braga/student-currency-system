package com.lds.student_currency_system.application.dto;

public record ProfessorResponse(
    Long id,
    String name,
    String email,
    String cpf,
    String institution,
    String department,
    Float balance 
) {
    
}
