package org.example.exception;

import org.example.DTO.error.Exception_Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler(Exceptions.class)
    public Exception_Response datanotfound(Exceptions error){
         Exception_Response excresp=new Exception_Response();
         excresp.setMessage(error.getMessage());
         excresp.setTimestamp(LocalDateTime.now());
         excresp.setStatus(HttpStatus.NOT_FOUND.value());

        return excresp;
    }

    @ExceptionHandler(ApiException.class)
    public Exception_Response nullpointer (ApiException error){
        Exception_Response excresp=new Exception_Response();
        excresp.setMessage(error.getMessage());
        excresp.setTimestamp(LocalDateTime.now());
        excresp.setStatus(HttpStatus.NOT_FOUND.value());
        return excresp;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Exception_Response handleValidationExcept(MethodArgumentNotValidException ex){

        Exception_Response excresp=new Exception_Response();

        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + "  : " + err.getDefaultMessage())
                .findFirst()
                .orElse("Validation error");

        excresp.setMessage(errorMessage);
        excresp.setTimestamp(LocalDateTime.now());
        excresp.setStatus(HttpStatus.BAD_REQUEST.value());

        return excresp ;
    }



}
