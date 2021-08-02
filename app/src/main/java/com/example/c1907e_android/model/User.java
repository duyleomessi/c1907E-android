package com.example.c1907e_android.model;

public class User {
    private String login;
    private String avatar;

    public User() {
    }

    public User(String login, String avatar) {
        this.login = login;
        this.avatar = avatar;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}

