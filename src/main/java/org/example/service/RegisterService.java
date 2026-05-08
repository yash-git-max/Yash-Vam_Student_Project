package org.example.service;

import org.example.DTO.request.RegisterRequestDTO;
//import org.example.DTO.response.LoginResponse;
import org.example.DTO.response.GeniricResponse;
import org.example.DTO.response.RegisterResponse;

public interface RegisterService {

    public GeniricResponse<RegisterResponse> addUserService(RegisterRequestDTO register);
}
