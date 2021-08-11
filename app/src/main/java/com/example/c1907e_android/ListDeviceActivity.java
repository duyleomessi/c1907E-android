package com.example.c1907e_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class ListDeviceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_device);

        SharedPreferences preferenceManager = PreferenceManager.getDefaultSharedPreferences(this);
        String access_token = preferenceManager.getString("acess-token", "");
        Toast.makeText(this, access_token, Toast.LENGTH_SHORT).show();
    }
}