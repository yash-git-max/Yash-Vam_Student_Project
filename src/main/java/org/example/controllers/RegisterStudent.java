package org.example.controllers;

import jakarta.validation.Valid;
import org.example.DTO.request.RegisterRequestDTO;
//import org.example.DTO.response.LoginResponse;
import org.example.DTO.response.GeniricResponse;
import org.example.DTO.response.RegisterResponse;
import org.example.DTO.response.RegisterResponseDTO;
import org.example.domain.Register;
import org.example.service.Impl.RegisterServiceImpl;
import org.example.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registerStudents")
public class RegisterStudent {

   private final RegisterService registerService;


    @Autowired
    public RegisterStudent(RegisterService registerService) {
        this.registerService = registerService;
    }


    @PostMapping("/details")
    public GeniricResponse<RegisterResponse> addUser(@Valid @RequestBody RegisterRequestDTO register){
    return registerService.addUserService(register) ;
    }



}
