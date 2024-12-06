package com.lds.student_currency_system.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ChangePasswordRequest(
        @NotBlank(message = "Current password is required.") 
        String currentPassword,

        @NotBlank(message = "New password is required.") 
        @Size(min = 6, message = "New password must have at least 6 characters.") 
        String newPassword
) {}
