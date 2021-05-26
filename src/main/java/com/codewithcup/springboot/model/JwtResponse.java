package com.codewithcup.springboot.model;

public class JwtResponse {
    private String token;

    // Default Constructor
    public JwtResponse() {
    }

    //Parameterized Constructor
    public JwtResponse(String token) {
        this.token = token;
    }

    //Getter and Setter
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
