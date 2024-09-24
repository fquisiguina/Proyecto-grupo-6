package com.msf.customer.middleend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler({
            Exception.class
    })
    public ResponseEntity<String> exceptionNotController(Exception e) {
        System.out.println("error----------");
        return ResponseEntity.badRequest().body("ERROR EN LA PETICION");
    }

}
