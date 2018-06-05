package com.luisro00005513.pruebaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.luisro00005513.pruebaretrofit.network.Login;
import com.luisro00005513.pruebaretrofit.network.News;
import com.luisro00005513.pruebaretrofit.network.NewsService;


import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.os.SystemClock.sleep;

public class MainActivity extends AppCompatActivity {

    TextView titulo;
    //en esta varibale pongo la base de la url, en la interfaz NewsService pongo el resto "/news" por ejemplo
    public static final String BASE_URL = "https://gamenewsuca.herokuapp.com";
    //en esta variable "global" guardo el token que genere getToken()
    private static String token;
    //====================retrofit===================
    Retrofit.Builder buider = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = buider.build();
    NewsService newsService = retrofit.create(NewsService.class);
    //====================retrofit(fin)===================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titulo = (TextView)findViewById(R.id.texto_news);
        getToken();
        //sleep(2000);
        getListaNoticias(token);

    }//on create

    //=============metodos retrofit==================


    //==============aca creo el metodo que llame en la interfaz(NewsService) para POST========================
    private void getToken(){
        Login login = new Login("username","password");
        Call<Login> call = newsService.getToken(login);
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this,response.body().getToken(),Toast.LENGTH_SHORT).show();
                    token = response.body().getToken();
                }
                else{
                    Toast.makeText(MainActivity.this,"Fail :(",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Fail de conexion perro :(",Toast.LENGTH_SHORT).show();
            }
        });

    }//getToken


    //==============aca creo el metodo que llame en la interfaz(NewsService) para GET========================
    private void getListaNoticias(String token){
        //le envio el token
        Call<ResponseBody> call = newsService.getListaNoticias("Bearer " + token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    try {
                        //me imprime el json en toast
                        Toast.makeText(MainActivity.this,response.body().string(),Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        //quiero que le textview me imprima lo de json pero no lo hace :(
                        titulo.setText(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }//if
                else{
                    Toast.makeText(MainActivity.this,"Fail en getListaNoticias :(",Toast.LENGTH_SHORT).show();
                }//else
            }//onResponse

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });



    }//getListaNoticias






}//main class
