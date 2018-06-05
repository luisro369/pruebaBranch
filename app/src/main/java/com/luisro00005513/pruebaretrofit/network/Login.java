package com.luisro00005513.pruebaretrofit.network;

/**
 * Created by luisro on 6/5/18.
 */

public class Login {
    String user;
    String password;
    String token;

    public Login(String user, String password){
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
