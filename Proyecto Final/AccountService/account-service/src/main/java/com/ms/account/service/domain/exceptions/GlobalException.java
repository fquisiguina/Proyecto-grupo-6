package com.ms.account.service.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler({
            Exception.class
    })
    public ResponseEntity<com.ms.account.service.server.models.Error> exceptionNotController(Exception ex) {
        System.out.println("exception");

        if (ex.getMessage().contains("Failed to convert value of type")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(this.error("ERROR","ID con caracteres especiales",ex.getMessage()));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(this.error("ERROR","Detalle del error",ex.getMessage()));
    }

    @ExceptionHandler(
            AccountNotFoundException.class
    )
    public ResponseEntity<com.ms.account.service.server.models.Error> accountNotFoundException(AccountNotFoundException ex) {
        System.out.println("AccountNotFoundException");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(this.error("ERROR","Detalle del error",ex.getMessage()));
    }

    com.ms.account.service.server.models.Error error (String tittle, String detail, String message) {
        com.ms.account.service.server.models.Error error = new com.ms.account.service.server.models.Error();
        error.setTittle(tittle);
        error.setDetail(detail);

        com.ms.account.service.server.models.ErrorDetail errorDetail = new com.ms.account.service.server.models.ErrorDetail();
        errorDetail.setMessage(message);

        error.setErrors(new ArrayList<>());
        error.getErrors().add(errorDetail);
        return error;
    }

}
