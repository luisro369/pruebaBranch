package com.luisro00005513.pruebaretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;


/**
 * Created by luisro on 6/3/18.
 */

//===========Esta interface nos va a ayudar con retrofit======

public interface NewsService {

    @GET("News/{title}")
    Call<News> getTitle(@Path("title") String title);
    //Call<News> getTitle(@Header("Authorization") String credentials);
    void getNew(Callback<List<News>> callback);

}
