package com.example.c1907e_android;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncCheckIP extends AsyncTask<String, Void, String> {
    private TextView ipTextView;
    private Context context;
    private ProgressDialog progressDialog;

    public AsyncCheckIP(Context context, TextView textView) {
        this.context = context;
        this.ipTextView = textView;
    }

    @Override
    public void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Kiểm tra IP");
        progressDialog.setMessage("Đang check ...");
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
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

                br.close();
                inputStreamReader.close();
                connection.getInputStream().close();
                return sb.toString();
            }
        } catch (IOException exception) {
            Log.e("checkIP", exception.getMessage());
        }
        return null;
    }

    @Override
    public void onPostExecute(String message) {
        super.onPostExecute(message);
        progressDialog.dismiss();
        this.ipTextView.append(message);
    }
}
