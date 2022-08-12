package com.vttp2022.ssfassessment.model;

import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonString;

public class Data {
    
    private String id;
    private int published_on;
    private String title;
    private String url;
    private String imageurl;
    private String body;
    private String tags;
    private String categories;

    public static Data createJson(JsonObject jo){
        Data d =new Data();

        JsonString jsId = jo.getJsonString("id");
        d.id = jsId.getString();

        JsonNumber jnPublishedOn = jo.getJsonNumber("published_on");
        d.published_on = jnPublishedOn.intValue();

        JsonString jsTitle = jo.getJsonString("title");
        d.title = jsTitle.getString();

        JsonString jsUrl = jo.getJsonString("url");
        d.url = jsUrl.getString();

        JsonString jsImageUrl = jo.getJsonString("imageurl");
        d.imageurl = jsImageUrl.getString();

        JsonString jsBody = jo.getJsonString("body");
        d.body = jsBody.getString();

        JsonString jsTags = jo.getJsonString("tags");
        d.tags = jsTags.getString();

        JsonString jsCategories = jo.getJsonString("categories");
        d.categories = jsCategories.getString();
        return d;

    
    }

    public Data(){
        
    }

    public Data(String id, int published_on, String title, String url, String imageurl, String body, String tags,
            String categories) {
        this.id = id;
        this.published_on = published_on;
        this.title = title;
        this.url = url;
        this.imageurl = imageurl;
        this.body = body;
        this.tags = tags;
        this.categories = categories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPublished_on() {
        return published_on;
    }

    public void setPublished_on(int published_on) {
        this.published_on = published_on;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }


}
