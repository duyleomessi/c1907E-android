package com.example.c1907e_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SavedInstanceState extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private EditText confirmPassword;
    private Button registerBtn;
    private TextView comparePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showToast("onCreate");
        setContentView(R.layout.activity_saved_instance_state);

        username = (EditText) findViewById(R.id.save_inst_user_name);
        password = (EditText) findViewById(R.id.save_inst_password);
        confirmPassword = (EditText) findViewById(R.id.save_inst_confirm_password);
        registerBtn = (Button) findViewById(R.id.save_inst_btn_register);
        comparePass = (TextView) findViewById(R.id.save_inst_compare_pass);

        if (savedInstanceState != null) {
            String comparePassResult = savedInstanceState.getString("comparePassResult");
            comparePass.setText(comparePassResult);
        }

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (password.getText().toString().equals(confirmPassword.getText().toString())) {
                    comparePass.setText("Password is match");
                } else {
                    comparePass.setText("Password is mismatch");
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("comparePassResult", comparePass.getText().toString());
        showToast("onSaveInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "OnRestart", Toast.LENGTH_SHORT).show();
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}