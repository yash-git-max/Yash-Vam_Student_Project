package org.example.service.Impl;

import org.example.DTO.response.GeniricResponse;
//import org.example.DTO.response.LoginResponse;
import org.example.domain.Login;
import org.example.exception.loginExceptions.InvalidPasswordException;
import org.example.exception.loginExceptions.LoginIdNotFound;
import org.example.repository.LoginRepository;
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository loginRepository;
    @Override
    public GeniricResponse<Login> checkLoginDetails(Login login) {
//        if(loginRepository.find(login.getId())){
//            LoginResponse<Login> loginResponse=new LoginResponse<>();
//            loginResponse.setStatus(HttpStatus.OK.value());
//            loginResponse.setMessage("Valid User");
//            loginResponse.setTimestamp(LocalDateTime.now());
//            Login login1=loginRepository.findById(Long.valueOf(login.getId())).orElseThrow(()->new LoginIdNotFound("You're not registered"));
//            loginResponse.setData(List.of(login1));
//            return loginResponse;
//        }
//        else {
//            throw new LoginIdNotFound("You're not registered kindly Create an account please !");
//        }


        Login loginopt= loginRepository.
                findByMail(login.getMail())
                .orElseThrow(() -> new LoginIdNotFound("User not registered",HttpStatus.NOT_ACCEPTABLE));

        if(!loginopt.getPassword().equals(login.getPassword())){
            throw new InvalidPasswordException("Password is wrong");
        }
        GeniricResponse<Login> genericResponse=new GeniricResponse<>();
        genericResponse.setStatus(HttpStatus.OK.value());
        genericResponse.setMessage("Valid User");
        genericResponse.setTimestamp(LocalDateTime.now());
        genericResponse.setData(List.of(loginopt));
            return genericResponse;

    }
}
