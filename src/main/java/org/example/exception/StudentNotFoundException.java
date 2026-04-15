package org.example.exception;

import org.springframework.http.HttpStatus;

public class StudentNotFoundException extends ApiException{

    public StudentNotFoundException(HttpStatus status) {
        super("student is not listed here ", status);
    }
}
