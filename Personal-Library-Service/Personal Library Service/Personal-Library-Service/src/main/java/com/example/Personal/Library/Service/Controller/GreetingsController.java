package com.example.Personal.Library.Service.Controller;

import com.example.Personal.Library.Service.Service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetingsController {

    @Autowired
    GreetingService greetingService;

    // Field Injection
    @Autowired
    GreetingService morningGreetingService;
    GreetingService eveningGreetingService;

    // Construtor Injection
    @Autowired
    public GreetingsController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // Setter Injection
    @Autowired
    @Qualifier("eveningGreetingService")
    public void setGreetingService(GreetingService greetingService) {
        this.eveningGreetingService = greetingService;
    }

    @GetMapping("/morning/{name}")
    public String SendMorningGreetingService(@PathVariable String name) {
        return morningGreetingService.greet(name);
    }

    @GetMapping("/evening/{name}")
    public String SendEveningGreetingService(@PathVariable String name) {
        return eveningGreetingService.greet(name);
    }

    @GetMapping("/default/{name}")
    public String SendDefaultGreetingService(@PathVariable String name) {
        return greetingService.greet(name);
    }
}
