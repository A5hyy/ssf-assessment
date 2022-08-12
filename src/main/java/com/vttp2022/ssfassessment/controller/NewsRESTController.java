package com.vttp2022.ssfassessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vttp2022.ssfassessment.model.Data;
import com.vttp2022.ssfassessment.service.NewsService;

@RestController
public class NewsRESTController {
    @Autowired
    NewsService service;
    @GetMapping("/showArticle/<id>")
    public String showId(Model model, @PathVariable(value="id")String id){
        Data redisLoad = service.load(id);
        model.addAttribute("published_on", redisLoad.getPublished_on());
        model.addAttribute("title", redisLoad.getTitle());
        model.addAttribute("url", redisLoad.getUrl());
        model.addAttribute("imageurl", redisLoad.getImageurl());
        model.addAttribute("body", redisLoad.getBody());
        model.addAttribute("tags", redisLoad.getTags());
        model.addAttribute("categories", redisLoad.getCategories());
        return "return";
    }
}
