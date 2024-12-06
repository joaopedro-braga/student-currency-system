package com.lds.student_currency_system.application.dto;

import com.lds.student_currency_system.domain.enums.UserRole;

public record AuthenticationResponse(String token, UserRole role) {
    
}
