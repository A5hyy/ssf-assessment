package com.vttp2022.ssfassessment.controller;


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

import com.vttp2022.ssfassessment.model.newsData;


@Controller
@RequestMapping(path="/")
public class NewsController {

    RestTemplate template = new RestTemplate();

    
@GetMapping("/")
public String getIndex(@ModelAttribute newsData test){

    return "index";
    }

@PostMapping("/showArticle")
public String getArticle(@ModelAttribute newsData test, Model model){
    String url = "https://min-api.cryptocompare.com/data/v2/news/?lang=EN";
    String apiKey = System.getenv("API_KEY");

    RequestEntity<Void> request = RequestEntity.get(url)
    .header("apikey", apiKey)
    .accept(MediaType.APPLICATION_JSON)
    .build();
ResponseEntity<newsData> response = template.exchange(request, newsData.class);

    newsData ndata = response.getBody();

    model.addAttribute("id", ndata.getId());
        model.addAttribute("published_on", ndata.getPublished_on());
        model.addAttribute("title", ndata.getTitle());
        model.addAttribute("url", ndata.getUrl() );
        model.addAttribute("imageurl", ndata.getImageurl() );
        model.addAttribute("body", ndata.getBody() );
        model.addAttribute("tags", ndata.getTags() );
        model.addAttribute("categories", ndata.getCategories() );

    return "article";
    }

}
