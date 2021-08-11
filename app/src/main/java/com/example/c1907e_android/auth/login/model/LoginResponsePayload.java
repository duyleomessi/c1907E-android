package com.example.c1907e_android.auth.login.model;

public class LoginResponsePayload {
    private String jwt;

    public LoginResponsePayload() {
    }

    public LoginResponsePayload(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
