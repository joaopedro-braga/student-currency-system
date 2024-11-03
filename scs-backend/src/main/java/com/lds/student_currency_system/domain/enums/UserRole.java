package com.lds.student_currency_system.domain.enums;

public enum UserRole {
    ADMIN("ADMIN"),
    STUDENT("STUDENT"),
    COMPANY("COMPANY"),
    PROFESSOR("PROFESSOR");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

