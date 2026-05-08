package org.example.exception.RegisterExceptions;

import org.example.DTO.error.Exception_Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public Exception_Response RegisterUniversalException(org.springframework.web.bind.MethodArgumentNotValidException ex){
     Exception_Response exceptionResponse=new Exception_Response();
     exceptionResponse.setMessage("Vamshi check the params please "+ex.getMessage());
     exceptionResponse.setTimestamp(LocalDateTime.now());
     exceptionResponse.setStatus(ex.getStatusCode().value());
     return exceptionResponse;
    }


}
