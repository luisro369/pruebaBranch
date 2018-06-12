package com.luisro00005513.pruebaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.luisro00005513.pruebaretrofit.network.Login;
import com.luisro00005513.pruebaretrofit.network.News;
import com.luisro00005513.pruebaretrofit.network.NewsService;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.os.SystemClock.sleep;

public class MainActivity extends AppCompatActivity {

    TextView titulo,game,body;
    //en esta varibale pongo la base de la url, en la interfaz NewsService pongo el resto "/news" por ejemplo
    public static final String BASE_URL = "https://gamenewsuca.herokuapp.com";
    //en esta variable "global" guardo el token que genere getToken()
    private static String token;
    //hago un arreglo de objetos news para poder setear el pojo
    ArrayList<News> news_list = new ArrayList<>();


    //====================aca esta todo lo necesarios para la conexion inicial con retrofit===================
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization","Bearer " + token)
                    .build();
            return chain.proceed(newRequest);
        }
    }).build();


    Retrofit.Builder buider = new Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = buider.build();
    NewsService newsService = retrofit.create(NewsService.class);
    //====================retrofit(fin)===================



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titulo = (TextView)findViewById(R.id.title_xml);
        game = (TextView)findViewById(R.id.game_xml);
        body = (TextView)findViewById(R.id.body_xml);
        //este metodo inicializa toda la recoleccion de datos de retrofit, seguir cadena de llamadas
        //de metodos para entender, pero al final de que se complete el arreglo de News (news_list)
        //ya estaria lleno y listo
        getToken();
        //debido a que es un arreglo para recolectar los datos tengo que acceder a una casilla de dichos datos
        //recordar que retrofit devuelve un monton de noticias del api

    }//on create

    public void imprimirMierdas(){

        titulo.setText(news_list.get(0).getTitle());
        game.setText(news_list.get(0).getGame());
        body.setText(news_list.get(0).getBody());

    }




    //=============metodos retrofit==================
    //==============aca creo el metodo que llame en la interfaz(NewsService) para POST========================
    private void getToken(){
        Login login = new Login("username","password");
        Call<Login> call = newsService.getToken(login);
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if(response.isSuccessful()){
                    token = response.body().getToken();
                    Toast.makeText(MainActivity.this,"El token es: "+response.body().getToken(),Toast.LENGTH_SHORT).show();
                    //=====si tuvimos exito y generamos un token manda a llama lo demas========
                    //getListaNoticias(token);
                    getTitles();
                }
                else{
                    Toast.makeText(MainActivity.this,"Fallo al agarrar token",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Fallo de conexion",Toast.LENGTH_SHORT).show();
            }
        });

    }//getToken





    private void getTitles(){
        Call<List<News>> call = newsService.getTitles("title","game","_id","body", "date",
                "coverImage", "description");
        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                Toast.makeText(MainActivity.this,"Conexion exitosa",Toast.LENGTH_SHORT).show();
                    //Noticia completa
                    String id = response.body().get(0).getId();
                    String imagen = response.body().get(0).getCoverImage();
                    String body = response.body().get(0).getBody();
                    String date = response.body().get(0).getCreatedDate();
                    String description = response.body().get(0).getDescription();
                    //cardviews
                    String titulo = response.body().get(0).getTitle();
                    String game = response.body().get(0).getGame();
                    //utilizo el contructor de la clase News para ir metiendo las mierdas
                    news_list.add(new News(id,titulo,body,game,date,imagen,description));//arreglo para noticia

                    imprimirMierdas();
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"fallo de recoleccion de datos",Toast.LENGTH_SHORT).show();

            }
        });

    }//getTitles


}//main class
