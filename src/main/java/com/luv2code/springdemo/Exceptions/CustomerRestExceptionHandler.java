package com.luv2code.springdemo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {


    //handling the exceptions finally
    @ExceptionHandler
    public ResponseEntity<CustomerErrorRespond> handleException(CustomersNotFoundException ex){

        CustomerErrorRespond error = new CustomerErrorRespond();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        //return responseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //adding another handler to catch any exception
    @ExceptionHandler
    public ResponseEntity<CustomerErrorRespond> handleException(Exception ex){


        CustomerErrorRespond error = new CustomerErrorRespond();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return responseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


}
