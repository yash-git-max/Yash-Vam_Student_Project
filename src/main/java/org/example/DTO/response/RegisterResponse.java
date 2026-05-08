package org.example.DTO.response;

public class RegisterResponse {


    private long id;

    private String mail;

    public RegisterResponse(long id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
