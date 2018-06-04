package com.luisro00005513.pruebaretrofit;

import android.widget.ImageView;


import android.media.Image;
import android.widget.ImageView;

import java.util.Date;

/**
 * Created by luisro on 6/1/18.
 */

public class News {

    int id;
    String title;
    ImageView coverImage;//el tipo de dato puede cambiar
    Date create_date;
    String description;
    String body;
    String game;

    //----------------constructor para cardview de noticia---------------
    public News(String title, String description) {
        this.title = title;
        this.description = description;
    }

    //-----------------constructor para full noticia------------
    public News(int id, String title, ImageView coverImage, Date create_date, String description, String body, String game) {
        this.id = id;
        this.title = title;
        this.coverImage = coverImage;
        this.create_date = create_date;
        this.description = description;
        this.body = body;
        this.game = game;
    }

    //======================setters y getters=========================


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ImageView getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(ImageView coverImage) {
        this.coverImage = coverImage;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    //====================retrofit implementation============


    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", coverImage=" + coverImage +
                ", create_date=" + create_date +
                ", description='" + description + '\'' +
                ", body='" + body + '\'' +
                ", game='" + game + '\'' +
                '}';
    }
}
