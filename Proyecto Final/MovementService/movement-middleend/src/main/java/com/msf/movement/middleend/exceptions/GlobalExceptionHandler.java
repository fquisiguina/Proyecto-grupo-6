package com.msf.movement.middleend.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msf.movement.middleend.domain.Error;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Error> handleFeignException(FeignException ex) {
        Error error = new Error();
        error.setTitle("Conflict");
        error.setDetail(ex.getMessage());
        error.setStatus(HttpStatus.CONFLICT.value());


        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
