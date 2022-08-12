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

public class News {
    
    private static List<Data> data = new ArrayList<>();

    public static List<Data> getData() {
        return data;
    }

    public static void setNewsdata(List<Data> data) {
        News.data = data;
    }

   public static News createJson(String json) throws IOException{
    News n = new News();

    try(InputStream in = new ByteArrayInputStream(json.getBytes())){
        JsonReader jr = Json.createReader(in);
        JsonObject jo = jr.readObject();
        JsonArray ja = jo.getJsonArray("Data");

        if(ja != null){
            List<Data> result = new ArrayList<>();
            for(Object jd:ja){
                JsonObject joData = (JsonObject) jd;
                result.add(Data.createJson(joData));
            }
            News.data = result;
        
    }
}
    return n;
   }
}
    
   

