package com.lds.student_currency_system.application.dto;

public record StudentRequest(
    String name, 
    String email, 
    String password, 
    String cpf, 
    String address, 
    Long institutionId, 
    String course) {
    
}
