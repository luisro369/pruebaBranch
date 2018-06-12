package com.luisro00005513.pruebaretrofit.network;

/**
 * ESTA CLASE LA OCUPO PARA PODER USAR EL TOKEN, LOS VALORES DE USER Y PASWORD SON SETEADOS EN EL MAIN
 * SEGUN LA API EL USUARIO POR DEFALUT ES: username Y EL PASSWORD ES: password
 * ENTIENDO QUE AL HACER ESTO ESTA CLASE ES UN POJO
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
