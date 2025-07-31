package com.example.Personal.Library.Service.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/health")
    public String testEndpoint() {
        return "OK";
    }
}
