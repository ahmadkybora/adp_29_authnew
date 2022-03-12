package com.example.adp_29_authnew.Models;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("name")
    public String name;

    @SerializedName("email")
    public String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
