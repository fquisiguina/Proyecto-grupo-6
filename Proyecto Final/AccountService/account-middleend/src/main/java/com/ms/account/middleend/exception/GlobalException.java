package com.ms.account.middleend.exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.net.ConnectException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import com.ms.account.middleend.domain.Error;

@ControllerAdvice
public class GlobalException {



    @ExceptionHandler({
            //feign.FeignException.BadRequest.class,
            //feign.FeignException.BadGateway.class,
            FeignException.class
    })
    public ResponseEntity<Error> handleFeignException(FeignException ex) {
        Error error = new Error();
        error.setTitle("Conflict");
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
        error.setTitle("Connection Refused");
        error.setDetail("Error Detail: " + ex.getMessage());
        //error.setErrors(List.of());
        error.setStatus(HttpStatus.CONFLICT.value()); //409
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(
            MethodArgumentTypeMismatchException.class
    )
    public ResponseEntity<Error> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        //400
        Error error = new Error();
        error.setTitle("Failed to convert value of type");
        error.setDetail("Error Detail: " + ex.getMessage());
        //error.setErrors(List.of());
        error.setStatus(HttpStatus.BAD_REQUEST.value()); //400
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(
            AccountNotFoundException.class
    )
    public ResponseEntity<Error> accountNotFoundException(AccountNotFoundException ex) {
        //204
        Error error = new Error();
        error.setTitle("Account Not Found");
        error.setDetail("Error Detail: " + ex.getMessage());
        //error.setErrors(List.of());
        error.setStatus(HttpStatus.NO_CONTENT.value()); //204
        return new ResponseEntity<>(error, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(
            NotUpdateAmountException.class
    )
    public ResponseEntity<Error> notUpdateAmountException(NotUpdateAmountException ex) {
        //409
        Error error = new Error();
        error.setTitle("Not Update Amount");
        error.setDetail("Error Detail: " + ex.getMessage());
        //error.setErrors(List.of());
        error.setStatus(HttpStatus.CONFLICT.value()); //409
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }






    @ExceptionHandler({
            SQLException.class
    })
    public ResponseEntity<Error> sqlException(SQLException ex){
        //System.out.println("codigo" + exception.getErrorCode());
        //SQLExceptionEnum sqlExceptionEnum = SQLExceptionEnum.fromCode(exception.getErrorCode());

        Error error = new Error();
        error.setTitle("SQL Error");
        error.setDetail("Error Detail: " + ex.getMessage());
        //error.setErrors(List.of());
        error.setStatus(HttpStatus.BAD_REQUEST.value()); //400

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    public ResponseEntity<Error> methodArgumentNotValidException(MethodArgumentNotValidException ex){
        //List<ErrorDetail> violations = exception.getBindingResult()
        //        .getAllErrors()
        //        .stream()
        //        .map(error -> Util.generateErrorDetail(error))
        //        .collect(Collectors.toList());

        Error error = new Error();
        error.setTitle("Violation Error");
        error.setDetail("Error Detail: " + ex.getMessage());
        //error.setErrors(violations);
        error.setStatus(HttpStatus.BAD_REQUEST.value()); //400

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({
            MissingRequestHeaderException.class
    })
    public ResponseEntity<Error> missingRequestHeaderException(MissingRequestHeaderException ex){
        Error error = new Error();
        error.setTitle("Headers Error");
        error.setDetail("Error Detail: " + ex.getMessage());
        //error.setErrors(List.of());
        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
