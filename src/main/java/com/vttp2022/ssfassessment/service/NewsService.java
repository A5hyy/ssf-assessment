package com.vttp2022.ssfassessment.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.vttp2022.ssfassessment.model.Data;


@Service
public class NewsService implements NewsRepo {
    // data to save into redis
    @Autowired
    RedisTemplate<String, Data> redisTemplate;

    public void save(Data data){
        Random r = new Random();
        StringBuilder strBuilder = new StringBuilder();
        while (strBuilder.length() < 8) {
            strBuilder.append(Integer.toHexString(r.nextInt()));
        }
        redisTemplate.opsForValue().set(strBuilder.toString(), data);
    
    }

    public Data load(String load){
        Data redisConvert = redisTemplate.opsForValue().get(load);
        return redisConvert;

    }
}
