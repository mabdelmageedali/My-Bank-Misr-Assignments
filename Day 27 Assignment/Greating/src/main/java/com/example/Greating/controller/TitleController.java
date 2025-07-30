package com.example.Greating.controller;

import com.example.Greating.config.AppProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TitleController {
    private final AppProperties appProperties;

    public TitleController(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @GetMapping("/title")
    public String getTitle() {
        return appProperties.getTitle();
    }
}
