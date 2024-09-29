package com.msa.customer.service.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ms.customer.service.server.models.Error;

import java.util.List;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(
            CustomerNotFoundException.class
    )
    public ResponseEntity<Error> accountNotFoundException(CustomerNotFoundException ex) {
        //204
        Error error = new Error();
        error.setTitle("Customer Not Found");
        error.setDetail("Error Detail: " + ex.getMessage());
        error.setErrors(List.of());
        error.setStatus(HttpStatus.NOT_FOUND.value()); //204
        return ResponseEntity.badRequest().body(error);
    }
}
