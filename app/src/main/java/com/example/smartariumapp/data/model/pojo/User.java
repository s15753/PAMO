package com.example.smartariumapp.data.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    private String user;
    private String password;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
