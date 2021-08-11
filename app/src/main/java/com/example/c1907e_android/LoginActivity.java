package com.example.c1907e_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.c1907e_android.auth.login.model.LoginRequest;
import com.example.c1907e_android.auth.login.model.LoginResponse;
import com.example.c1907e_android.auth.login.service.AuthService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    private LoginResponse loginResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.activity_main_usernameEditText);
        passwordEditText = findViewById(R.id.activity_main_passwordEditText);
        loginButton = findViewById(R.id.activity_main_loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameEditText.getText().length() > 0 && passwordEditText.getText().length() > 0) {
                    String toastMessage = "Username: " + usernameEditText.getText().toString() + ", Password: " + passwordEditText.getText().toString();
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                    loginUser(usernameEditText.toString(), passwordEditText.toString());
                } else {
                    String toastMessage = "Username or Password are both required";
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void loginUser(String username, String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.5:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AuthService authService = retrofit.create(AuthService.class);
        authService.login(new LoginRequest(usernameEditText.toString(), passwordEditText.toString())).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                loginResponse = response.body();
                Log.e("LoginResponse", loginResponse.toString());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
}