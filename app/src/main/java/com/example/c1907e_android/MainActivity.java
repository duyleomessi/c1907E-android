package com.example.c1907e_android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button nextButton = (Button) findViewById(R.id.click_me);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putStringArray("info", new String[]{"abc", "28", "C1907E"});

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}
