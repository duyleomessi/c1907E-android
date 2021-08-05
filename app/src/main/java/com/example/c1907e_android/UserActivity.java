package com.example.c1907e_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;

import com.example.c1907e_android.post.model.User;
import com.example.c1907e_android.post.service.UserService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserActivity extends AppCompatActivity {
    RecyclerView rvUsers;
    private GithubUserAdapter githubUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // hiển thị loading
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        requestWindowFeature(Window.FEATURE_PROGRESS);

        setContentView(R.layout.activity_github_user);
        rvUsers = (RecyclerView) findViewById(R.id.act_gh_user_rv);
        githubUserAdapter = new GithubUserAdapter(this, new ArrayList<User>());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvUsers.setLayoutManager(layoutManager);
        rvUsers.setAdapter(githubUserAdapter);

        setProgressBarIndeterminateVisibility(true);
        setProgressBarVisibility(true);
        loadGitHubUsers();
    }

    public void loadGitHubUsers() {
        List<User> users = new ArrayList<>();
        rvUsers = (RecyclerView) findViewById(R.id.act_gh_user_rv);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserService userService = retrofit.create(UserService.class);
        userService.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                final List<User> users = response.body();
                githubUserAdapter.updateUsers(users);
                setProgressBarIndeterminateVisibility(false);
                setProgressBarVisibility(false);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
}