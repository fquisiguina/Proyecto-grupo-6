package com.ms.account.service.domain.exceptions;

import com.ms.account.service.domain.enums.SQLExceptionEnum;
import com.ms.account.service.domain.util.Util;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.ms.account.service.server.models.Error;
import com.ms.account.service.server.models.ErrorDetail;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.net.ConnectException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalException {

    /*@ExceptionHandler({
            Exception.class
    })*/
    /*public ResponseEntity<Error> exceptionNotController(Exception ex) {
        //400
        Error error = new Error();
        error.setErrors(List.of());
        error.setStatus(HttpStatus.BAD_REQUEST.value()); //400


        //if (ex.getMessage().contains("Failed to convert value of type")) {
        //    error.setTittle("General Error");
        //    error.setDetail("ID con caracteres especiales: " + ex.getMessage());
        //    return ResponseEntity.badRequest().body(error);
        //}

        error.setTittle("General Error");
        error.setDetail("Error Detail: " + ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }*/

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Error> handleFeignException(FeignException ex) {
        Error error = new Error();
        error.setTittle("Conflict");
        error.setDetail(ex.getMessage());
        error.setStatus(HttpStatus.CONFLICT.value());

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(
            ConnectException.class
    )
    public ResponseEntity<Error> connectException(ConnectException ex) {
        //409
        Error error = new Error();
        error.setTittle("Connection Refused");
        error.setDetail("Error Detail: " + ex.getMessage());
        error.setErrors(List.of());
        error.setStatus(HttpStatus.CONFLICT.value()); //409
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(
            MethodArgumentTypeMismatchException.class
    )
    public ResponseEntity<Error> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        //400
        Error error = new Error();
        error.setTittle("Failed to convert value of type");
        error.setDetail("Error Detail: " + ex.getMessage());
        error.setErrors(List.of());
        error.setStatus(HttpStatus.BAD_REQUEST.value()); //400
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(
            AccountNotFoundException.class
    )
    public ResponseEntity<Error> accountNotFoundException(AccountNotFoundException ex) {
        //204
        Error error = new Error();
        error.setTittle("Account Not Found");
        error.setDetail("Error Detail: " + ex.getMessage());
        error.setErrors(List.of());
        error.setStatus(HttpStatus.NO_CONTENT.value()); //204
        return new ResponseEntity<>(error, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(
            NotUpdateAmountException.class
    )
    public ResponseEntity<Error> notUpdateAmountException(NotUpdateAmountException ex) {
        //409
        Error error = new Error();
        error.setTittle("Not Update Amount");
        error.setDetail("Error Detail: " + ex.getMessage());
        error.setErrors(List.of());
        error.setStatus(HttpStatus.CONFLICT.value()); //409
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }






    @ExceptionHandler({
            SQLException.class
    })
    public ResponseEntity<Error> sqlException(SQLException exception){
        System.out.println("codigo" + exception.getErrorCode());
        SQLExceptionEnum sqlExceptionEnum = SQLExceptionEnum.fromCode(exception.getErrorCode());

        Error error = new Error();
        error.setTittle("SQL Error");
        error.setDetail(sqlExceptionEnum.getDescription());
        error.setErrors(List.of());
        error.setStatus(HttpStatus.BAD_REQUEST.value()); //400

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
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
        error.setTittle("Violation Error");
        error.setDetail("The following conditions in the parameters were violated");
        error.setErrors(violations);
        error.setStatus(HttpStatus.BAD_REQUEST.value()); //400

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({
            MissingRequestHeaderException.class
    })
    public ResponseEntity<Error> missingRequestHeaderException(MissingRequestHeaderException exception){
        Error error = new Error();
        error.setTittle("Headers Error");
        error.setDetail("The following Header is mandatory: " + exception.getHeaderName());
        error.setErrors(List.of());
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
