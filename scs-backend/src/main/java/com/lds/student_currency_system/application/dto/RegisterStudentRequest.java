package com.lds.student_currency_system.application.dto;

import com.lds.student_currency_system.domain.model.Institution;

public record RegisterStudentRequest(String name, String email, String password, String cpf, String address, Institution institution, String course) {
    
}
