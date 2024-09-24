package com.msf.customer.middleend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class FeignException {

    @ExceptionHandler({
            //feign.FeignException.BadRequest.class,
            //feign.FeignException.BadGateway.class,
            feign.FeignException.class
    })
    public ResponseEntity<String> handleFeignExceptions(Exception ex) {
        if (ex instanceof feign.FeignException.BadRequest) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error Bad Request: " + ex.getMessage());
        } else if (ex instanceof feign.FeignException.BadGateway) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Error Bad Gateway: " + ex.getMessage());
        } else if (ex instanceof feign.FeignException.Conflict) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error CONFLICT: " + ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error desconocido: " + ex.getMessage());

    }
}
