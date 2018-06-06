package com.luisro00005513.pruebaretrofit.network;

import com.luisro00005513.pruebaretrofit.network.News;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by luisro on 6/3/18.
 */

//===========Esta interface nos va a ayudar con retrofit======

public interface NewsService {

    @POST("/login")
    Call<Login> getToken(@Body Login login);


    @GET("/news/{title}")
    public Call<ResponseBody> getTitles(@Query("title") String title);
    //public Call<News> getTitles(@Query("title") String title);
    //Call<ResponseBody> getListaNoticias(@Header("Authorization") String token);

   // @GET("/news")
    //public Call<News> getTitles(@Path("title") String title);

    /*
    @GET("News/{title}")
    //Call<News> getTitle(@Path("title") String title);
    Call<News> getTitle(@Header("Authorization") String credentials);
    void getNew(Callback<List<News>> callback);
    */

}
