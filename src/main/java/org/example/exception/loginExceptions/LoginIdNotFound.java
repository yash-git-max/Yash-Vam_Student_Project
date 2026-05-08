package org.example.exception.loginExceptions;

import org.example.exception.ApiException;
import org.springframework.http.HttpStatus;

public class LoginIdNotFound extends ApiException {
    public LoginIdNotFound(String message ,HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
