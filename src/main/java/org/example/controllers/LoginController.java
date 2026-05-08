package org.example.controllers;

import io.swagger.v3.oas.models.headers.Header;
//import org.example.DTO.response.LoginResponse;
import org.example.DTO.response.GeniricResponse;
import org.example.domain.Login;
import org.example.repository.LoginRepository;
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping(value = "/logindetails", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeniricResponse> logindetails(@RequestBody Login login){
       return new ResponseEntity<>(loginService.checkLoginDetails(login),HttpStatus.OK);
    }

}
