package com.luisro00005513.pruebaretrofit;

import java.util.List;

import retrofit2.Callback;
import retrofit2.http.GET;


/**
 * Created by luisro on 6/3/18.
 */

//===========Esta interface nos va a ayudar con retrofit======

public interface NewsService {

    @GET("/news/?access_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1YjBmNDE1NjdkMjZmZDAwMjBmNjMyN2IiLCJpYXQiOjE1MjgwNzIwNDgsImV4cCI6MTUyOTI4MTY0OH0.VhOgctxjzPezCoX-53yN_tilCUwiNSUvpnsdm2ICMvw")
    void getNew(Callback<List<News>> callback);

}
