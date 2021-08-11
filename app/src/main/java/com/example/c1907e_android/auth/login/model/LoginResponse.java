package com.example.c1907e_android.auth.login.model;


import com.google.gson.annotations.SerializedName;

class Payload {
    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

public class LoginResponse {
    @SerializedName("success")
    private boolean success;
    @SerializedName("payload")
    private Payload payload;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }
}
