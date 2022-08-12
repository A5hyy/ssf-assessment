package com.vttp2022.ssfassessment.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Article {
    
    private static List<newsData> newsdata = new ArrayList<>();

    public static List<newsData> getNewsdata() {
        return newsdata;
    }

    public static void setNewsdata(List<newsData> newsdata) {
        Article.newsdata = newsdata;
    }

   public static Article createJson(String json) throws IOException{
    Article a = new Article();

    try(InputStream in = ByteArrayInputStream(json.getBytes())){
        JsonReader r = Json.createReader(in);
        JsonObject o = r.readObject();
        JsonArray ja = o.getJsonArray("newsData");

        if(ja != null){
            List<newsData> result = new ArrayList<>();
            for(Object jd:ja){
                JsonObject joData = (JsonObject) jd;
                result.add(newsData.createJson(joData));
            }
            Article.newsdata = result;
        
    }
    

private static InputStream ByteArrayInputStream(byte[] bytes) {
    return null;
}
    
}
   

