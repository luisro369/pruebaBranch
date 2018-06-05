package com.luisro00005513.pruebaretrofit.network;



//===============java generado en www.jsonschema2pojo.org===============================
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("game")
    @Expose
    private String game;
    @SerializedName("created_date")
    @Expose
    private String createdDate;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("coverImage")
    @Expose
    private String coverImage;
    @SerializedName("description")
    @Expose
    private String description;

    /**
     * No args constructor for use in serialization
     *
     */
    public News(String title) {
        this.title = title;
    }

    /**
     *
     * @param id
     * @param v
     * @param body
     * @param title
     * @param description
     * @param game
     * @param createdDate
     * @param coverImage
     */
    public News(String id, String title, String body, String game, String createdDate, Integer v, String coverImage, String description) {
        super();
        this.id = id;
        this.title = title;
        this.body = body;
        this.game = game;
        this.createdDate = createdDate;
        this.v = v;
        this.coverImage = coverImage;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
