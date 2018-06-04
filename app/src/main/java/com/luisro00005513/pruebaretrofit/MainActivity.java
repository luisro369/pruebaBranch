package com.luisro00005513.pruebaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titulo = (TextView)findViewById(R.id.Texto_news);
        //====================codgigo para retrofit con news==========
        //usando retrofit 2.4
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gamenewsuca.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create()).build();

        NewsService servicio = retrofit.create(NewsService.class);
        servicio.getNew(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                //todos los datos han sido bajados correctamente
                if(titulo != null) {
                    titulo.setText(response.body().toString());
                }

            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                //si hay un error
                if(titulo != null) {
                    titulo.setText(t.toString());
                }

            }
        });



        /*Usando retrofit 1.9
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://gamenewsuca.herokuapp.com").build();
        NewsService  servicio = restAdapter.create(NewsService.class);
        servicio.getNew(new Callback<List<News>>() {
            @Override
            public void success(List<News> news, Response response) {
                //todos los datos han sido bajados correctamente
                if(titulo != null) {
                    titulo.setText(news.toString());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                //si hay un error
                if(titulo != null) {
                    titulo.setText(error.getMessage());
                }

            }
        });*/
        //====================codgigo para retrofit con news(fin)=====



    }
}
