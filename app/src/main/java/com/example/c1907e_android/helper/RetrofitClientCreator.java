package com.example.c1907e_android.helper;

import com.example.c1907e_android.interceptor.AuthInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientCreator {
    public static final String BASE_URL = "http://192.168.1.5:8080/";

    public static Retrofit getClientWithInterceptor() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AuthInterceptor())
                .build();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL) //This is the onlt mandatory call on Builder object.
                .client(okHttpClient) //The Htttp client to be used for requests
                .addConverterFactory(GsonConverterFactory.create()) // Convertor library used to convert response into POJO
                .build();
    }
}
