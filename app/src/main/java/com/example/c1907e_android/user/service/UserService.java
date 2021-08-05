package com.example.c1907e_android.user.service;

import com.example.c1907e_android.user.model.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {
    @GET("users")
    Call<List<User>> getUsers();

    @GET("users/{id}")
    Call<ResponseBody> getUserInfo(@Path("id") String id);
}
