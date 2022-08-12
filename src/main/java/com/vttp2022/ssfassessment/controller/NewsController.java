package com.vttp2022.ssfassessment.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.vttp2022.ssfassessment.model.Data;
import com.vttp2022.ssfassessment.service.NewsService;


@Controller
@RequestMapping(path="/")
public class NewsController {

    RestTemplate template = new RestTemplate();

@Autowired
NewsService service;     
@GetMapping("/")
public String getIndex(@ModelAttribute Data test, Model model){
    return "index";
} 
    

@PostMapping("/showArticle")
public String getArticle(@ModelAttribute Data test, Model model){
    String url = "https://min-api.cryptocompare.com/data/v2/news/?lang=EN";
    String apiKey = System.getenv("API_KEY");

    RequestEntity<Void> request = RequestEntity.get(url)
                                               .header("apikey", apiKey)
                                               .accept(MediaType.APPLICATION_JSON)
                                               .build();
    ResponseEntity<Data> response = template.exchange(request, Data.class);

    Data data = response.getBody();

    service.save(data);

    model.addAttribute("id", data.getId());
        model.addAttribute("published_on", data.getPublished_on());
        model.addAttribute("title", data.getTitle());
        model.addAttribute("url", data.getUrl() );
        model.addAttribute("imageurl", data.getImageurl() );
        model.addAttribute("body", data.getBody() );
        model.addAttribute("tags", data.getTags() );
        model.addAttribute("categories", data.getCategories() );

    return "article";
    }

}
