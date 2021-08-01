package com.example.c1907e_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CheckIpActivity extends AppCompatActivity {
    private TextView ipTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_ip);

        ipTextView = (TextView) findViewById(R.id.act_check_ip_id_tv);
        new AsyncCheckIP(this, ipTextView).execute();
    }

    public void checkIP() {
        try {
            StringBuilder sb;
            URL url = new URL("https://icanhazip.com/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader br = new BufferedReader(inputStreamReader);

                sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                this.ipTextView.append(sb.toString());
                br.close();
            }
        } catch (IOException exception) {
            Log.e("checkIP", exception.getMessage());
        }
    }
}
