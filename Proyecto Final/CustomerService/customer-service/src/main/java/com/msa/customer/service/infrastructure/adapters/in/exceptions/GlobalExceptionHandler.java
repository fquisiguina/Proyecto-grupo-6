package com.msa.customer.service.infrastructure.adapters.in.exceptions;

import com.ms.customer.service.server.models.Error;
import com.ms.customer.service.server.models.ErrorDetail;
import com.msa.customer.service.domain.exceptions.SQLExceptionEnum;
import com.msa.customer.service.domain.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            SQLException.class
    })
    public ResponseEntity<Error> sqlException(SQLException exception){
        SQLExceptionEnum sqlExceptionEnum = SQLExceptionEnum.fromCode(exception.getErrorCode());

        Error error = new Error();
        error.setTitle("SQL Error");
        error.setDetail(sqlExceptionEnum.getDescription());
        error.setErrors(List.of());
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    public ResponseEntity<Error> methodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ErrorDetail> violations = exception.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> Util.generateErrorDetail(error))
                .collect(Collectors.toList());

        Error error = new Error();
        error.setTitle("Violation Error");
        error.setDetail("The following conditions in the parameters were violated");
        error.setErrors(violations);
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler({
            MissingRequestHeaderException.class
    })
    public ResponseEntity<Error> missingRequestHeaderException(MissingRequestHeaderException exception){
        Error error = new Error();
        error.setTitle("Headers Error");
        error.setDetail("The following Header is mandatory: " + exception.getHeaderName());
        error.setErrors(List.of());
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.badRequest().body(error);
    }

}
