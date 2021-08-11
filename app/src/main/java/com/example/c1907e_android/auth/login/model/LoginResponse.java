package com.example.c1907e_android.auth.login.model;


import com.google.gson.annotations.SerializedName;


public class LoginResponse {
    @SerializedName("success")
    private Boolean success;
    @SerializedName("payload")
    private LoginResponsePayload payload;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public LoginResponsePayload getPayload() {
        return payload;
    }

    public void setPayload(LoginResponsePayload payload) {
        this.payload = payload;
    }
}
