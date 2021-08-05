package com.example.c1907e_android.post.model;

import com.google.gson.annotations.SerializedName;

public class User {
    private String login;
    @SerializedName("avatar_url")
    private String avatarUrl;

    public User() {
    }

    public User(String login, String avatarUrl) {
        this.login = login;
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar() {
        return avatarUrl;
    }

    public void setAvatar(String avatar) {
        this.avatarUrl = avatar;
    }
}
