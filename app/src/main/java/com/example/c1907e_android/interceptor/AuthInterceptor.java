package com.example.c1907e_android.interceptor;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;

import com.example.c1907e_android.auth.login.service.AuthService;
import com.example.c1907e_android.helper.RetrofitClientCreator;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

public class AuthInterceptor implements Interceptor {
    private static String token = null;


    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        /*
         * chain.request() returns original request that you can work with(modify, rewrite)
         */
        Request originalRequest = chain.request();


        // Here we can rewrite the request
        // We add an Authorization header if the request is not an authorize request and already had a token
        Request authRequest = originalRequest;
        if (!originalRequest.url().toString().contains("/auth") && getToken() != null) {
            authRequest = originalRequest.newBuilder().header("Authorization", "Bearer " + getToken()).build();
        }

        /*
         * chain.proceed(request) is the call which will initiate the HTTP work. This
         * call invokes the request and returns the response as per the request.
         */
        Response response = chain.proceed(authRequest);

        // Here we can rewrite/modify the response
        return response;
    }

    private String getToken() throws IOException {
        if (token != null) {
            return token;
        }
        return "test";
    }
}
