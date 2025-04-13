package com.estsoft.weeklyquiz.controller;

import com.estsoft.weeklyquiz.service.ExternalService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExternalApiController {

    private final ExternalService externalService;

    public ExternalApiController(ExternalService externalService) {
        this.externalService = externalService;
    }

    @GetMapping("/api/externalArticles")
    public ResponseEntity<Void> callExternalArticleData(){
        externalService.getArticles();
        return ResponseEntity.ok().build();
    }
    @GetMapping("/api/externalComments")
    public ResponseEntity<Void> callExternalCommentData(){
        externalService.getComments();
        return ResponseEntity.ok().build();
    }

}
