package com.lds.student_currency_system.application.dto;

public record CompanyRequest(
    String name, 
    String email, 
    String password, 
    String cnpj, 
    String address) {
    
}
