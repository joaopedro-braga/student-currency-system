package com.lds.student_currency_system.application.dto;

public record RegisterCompanyRequest(String name, String email, String password, String cnpj, String address) {
    
}
