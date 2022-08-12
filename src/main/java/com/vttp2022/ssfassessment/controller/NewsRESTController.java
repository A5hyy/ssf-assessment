package com.vttp2022.ssfassessment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsRESTController {
    @GetMapping("/news/<id>")
    public String showId(){


      
        return "return";
    }
}
