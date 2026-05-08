package org.example.service.Impl;

import org.example.DTO.request.RegisterRequestDTO;
import org.example.DTO.response.GeniricResponse;
//import org.example.DTO.response.LoginResponse;
import org.example.DTO.response.RegisterResponse;
import org.example.domain.Register;
import org.example.repository.RegisterRepository;
import org.example.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {


    @Autowired
    RegisterRepository registerRepository;

    public GeniricResponse<RegisterResponse> addUserService(RegisterRequestDTO registerRequestDTO){
        Register register =new Register();
        register.setMail(registerRequestDTO.getMail());
        register.setPassword(registerRequestDTO.getPassword());
        GeniricResponse<RegisterResponse> genericResponse =new GeniricResponse<>();
        genericResponse.setMessage("This is Your Data");
        genericResponse.setTimestamp(LocalDateTime.now());
        genericResponse.setStatus(HttpStatus.OK.value());
        registerRepository.save(register);
        RegisterResponse registerResponse =new RegisterResponse(register.getId(),register.getMail());
        genericResponse.setData(List.of(registerResponse));
        return genericResponse;
    }
}
