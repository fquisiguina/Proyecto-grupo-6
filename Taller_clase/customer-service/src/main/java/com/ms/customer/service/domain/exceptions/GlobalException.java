package com.ms.customer.service.domain.exceptions;

import com.ms.customer.service.domain.models.ErrorControlado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler({
            Exception.class
    })
    public ResponseEntity<ErrorControlado> exceptionNotController(Exception e) {
        System.out.println("ingreso de error");
        return ResponseEntity.badRequest().body(new ErrorControlado("1","Error de Peticion"));
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    public ResponseEntity<String> methodArgumentNotController(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error En ARGUMENTOS: " + ex.getMessage());

        /*if (ex instanceof MethodArgumentNotValidException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error En ARGUMENTOS: " + ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error desconocido: " + ex.getMessage());*/
    }
}
