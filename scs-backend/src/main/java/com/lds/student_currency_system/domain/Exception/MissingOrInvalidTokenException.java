package com.lds.student_currency_system.domain.Exception;

public class MissingOrInvalidTokenException extends RuntimeException {
    
    public MissingOrInvalidTokenException(String message) {
        super(message);
    }

    public MissingOrInvalidTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}
