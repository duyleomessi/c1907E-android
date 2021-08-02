package com.example.c1907e_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.c1907e_android.model.User;

import java.util.ArrayList;

public class GithubUserActivity extends AppCompatActivity {
    private RecyclerView rvUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_user);

        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("duy 1", ""));
        users.add(new User("duy 2", ""));
        users.add(new User("duy 3", ""));
        rvUsers = (RecyclerView) findViewById(R.id.act_gh_user_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvUsers.setLayoutManager(layoutManager);
        rvUsers.setHasFixedSize(true);
        rvUsers.setAdapter(new GithubUserAdapter(this, users));
    }
}