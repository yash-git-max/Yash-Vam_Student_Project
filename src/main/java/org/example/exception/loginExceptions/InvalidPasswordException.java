package org.example.exception.loginExceptions;

import org.example.exception.ApiException;
import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends ApiException {
    public InvalidPasswordException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
