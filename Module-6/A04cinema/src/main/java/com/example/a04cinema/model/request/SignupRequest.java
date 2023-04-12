package com.example.a04cinema.model.request;

import org.hibernate.validator.constraints.Length;

public class SignupRequest {

    @Length(min = 8, max = 32)
    private String username;
    @Length(min = 8, max = 32)
    private String password;

    public SignupRequest() {
    }

    public SignupRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
