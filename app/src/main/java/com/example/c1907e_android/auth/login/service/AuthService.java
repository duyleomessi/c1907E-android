package com.example.c1907e_android.auth.login.service;

import com.example.c1907e_android.auth.login.model.LoginRequest;
import com.example.c1907e_android.auth.login.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {
    @POST("users/authentication")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);
}
