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
 * INTERFAZ EN DONDE SE SETEAN LOS METODOS POST Y GET(ANALOGO A LO QUE SE HACE CON POSTMAN)
 */

//===========Esta interface nos va a ayudar con retrofit======

public interface NewsService {

    @POST("/login")
    Call<Login> getToken(@Body Login login);


    @GET("/news")

    public Call<List<News>> getTitles(@Query("title") String title, @Query("game") String game,
                                      @Query("_id") String id, @Query("body") String body,
                                      @Query("created_date") String date, @Query("coverImage") String image,
                                      @Query("description") String description);

}
