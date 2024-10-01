package com.msf.customer.middleend.exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.msf.customer.middleend.domain.Error;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalException {
    
    @ExceptionHandler({
            //feign.FeignException.BadRequest.class,
            //feign.FeignException.BadGateway.class,
            FeignException.class
    })
    public ResponseEntity<Error> handleFeignExceptions(FeignException ex) {
        Error error = new Error();
        error.setTitle("Conflict");
        error.setDetail(ex.toString());
        error.setStatus(HttpStatus.BAD_REQUEST.value());


        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            Exception.class
    })
    public ResponseEntity<Error> exception(Exception ex) {
        Error error = new Error();
        error.setTitle("Conflict");
        error.setDetail(ex.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());


        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Error> exception(SQLException ex) {
        Error error = new Error();
        error.setTitle("Conflict");
        error.setDetail(ex.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());


        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
