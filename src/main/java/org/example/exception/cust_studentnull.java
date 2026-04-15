package org.example.exception;

import org.springframework.http.HttpStatus;

public class cust_studentnull extends ApiException{
    public cust_studentnull(String message) {
        super("no students present "+message,HttpStatus.NO_CONTENT);
    }
}
