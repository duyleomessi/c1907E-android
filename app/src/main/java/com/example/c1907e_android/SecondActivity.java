package com.example.c1907e_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView usernameView = (TextView) findViewById(R.id.activity_second_username);
        TextView ageView = (TextView) findViewById(R.id.activity_second_age);
        TextView classView = (TextView) findViewById(R.id.activity_second_class);


        Bundle b = getIntent().getExtras();
        String[]infoArrayString = b.getStringArray("info");
        usernameView.append(infoArrayString[0]);
        ageView.append(infoArrayString[1]);
        classView.append(infoArrayString[2]);
    }
}