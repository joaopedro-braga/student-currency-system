package com.lds.student_currency_system.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfessorRequest(
    @NotNull
    @NotBlank(message = "Name is required.") 
    String name, 

    @NotNull
    @NotBlank(message = "Email is required.") 
    String email, 

    @NotNull
    @NotBlank(message = "CPF is required.") 
    String cpf, 

    @NotNull
    @NotBlank(message = "Institution is required.") 
    Long institutionId, 

    @NotNull
    @NotBlank(message = "Department is required.") 
    String department) {
}
