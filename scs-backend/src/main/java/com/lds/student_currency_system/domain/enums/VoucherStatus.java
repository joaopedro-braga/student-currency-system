package com.lds.student_currency_system.domain.enums;

public enum VoucherStatus {
    UNUSED("Unused"),
    USED("Used");

    private final String value;

    VoucherStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
