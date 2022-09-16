package com.luv2code.springdemo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomersNotFoundException extends RuntimeException{

    public CustomersNotFoundException(String message) {
        super(message);
    }

    public CustomersNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomersNotFoundException(Throwable cause) {
        super(cause);
    }

    protected CustomersNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
