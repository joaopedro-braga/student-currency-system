package com.lds.student_currency_system.domain.Exception;

public class CompanyAlreadyExistsException extends RuntimeException {

    public CompanyAlreadyExistsException(String message) {
        super(message);
    }

    public CompanyAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
