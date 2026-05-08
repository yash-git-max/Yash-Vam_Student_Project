package org.example.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Schema(description = "UsersLoginDetails")
@Entity
@Table(name = "LoginDetails")
public class Login {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email must not be empt")
    private String mail;
    @NotBlank(message = "Password should not be empty")
    @Size(min =3 , message = "Password Size must be at least 8 characters long")
    private String password;


    public Login(){}

    public Login(long id, String mail, String password) {
        this.id = id;
        this.mail = mail;
        this.password = password;
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
