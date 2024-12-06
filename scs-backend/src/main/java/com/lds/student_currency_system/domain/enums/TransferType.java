package com.lds.student_currency_system.domain.enums;

public enum TransferType {
    CREDIT("CREDIT"),
    DEBIT("DEBIT");

    private String type;

    TransferType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
