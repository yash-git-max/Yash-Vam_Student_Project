package org.example.exception;

import org.springframework.http.HttpStatus;

public class nostudents extends ApiException{
    public nostudents(){
        super("no Students preset kindly check GetAPI", HttpStatus.NO_CONTENT);
    }
}
