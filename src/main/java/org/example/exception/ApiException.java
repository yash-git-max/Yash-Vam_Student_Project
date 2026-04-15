package org.example.exception;

import org.springframework.http.HttpStatus;

public abstract class ApiException extends Exceptions{


    private final HttpStatus status;

    protected ApiException(String message, HttpStatus status){
        super(message);
        this.status=status;

    }

    public HttpStatus getStatus() {
        return status;
    }


}
