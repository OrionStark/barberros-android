package com.example.orionstark.barberros.models;

public class User {
    String username;
    String full_name;
    String no_telp;
    String email;
    String token;

    public User(String username, String full_name, String no_telp, String email, String token) {
        this.username = username;
        this.full_name = full_name;
        this.no_telp = no_telp;
        this.email = email;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }
}
