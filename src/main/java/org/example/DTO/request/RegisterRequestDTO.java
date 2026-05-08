package org.example.DTO.request;


import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequestDTO {

    @Email
    @NotBlank
    @Email(message = "Email is not Valid")
    private String mail;

//    @Hidden
//    private long id;
    @NotBlank
    @Size(min = 8,message = "Password is Incorrect")
    private String password;

//    public long getId() {
//        return id;
//    }

//    public void setId(long id) {
//        this.id = id;
//    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

