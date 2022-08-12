package com.vttp2022.ssfassessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vttp2022.ssfassessment.model.Data;
import com.vttp2022.ssfassessment.service.NewsService;

@RestController
@RequestMapping(path = "/showArticle", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class NewsRESTController {
    @Autowired
    NewsService service;

    @GetMapping(path = "/<id>")
    public ResponseEntity<Data> getArticleById(@PathVariable String aId) {
        Data data = service.findById(aId);
        return ResponseEntity.ok(data);
    }
}
