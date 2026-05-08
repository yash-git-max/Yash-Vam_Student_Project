package org.example.service;

//import org.example.DTO.response.LoginResponse;
import org.example.DTO.response.GeniricResponse;
import org.example.domain.Login;

public interface LoginService {

    public GeniricResponse<Login> checkLoginDetails(Login login);
    
}
