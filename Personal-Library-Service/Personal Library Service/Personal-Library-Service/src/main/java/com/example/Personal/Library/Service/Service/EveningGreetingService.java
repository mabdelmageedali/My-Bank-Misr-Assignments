package com.example.Personal.Library.Service.Service;

import org.springframework.stereotype.Component;

@Component
public class EveningGreetingService implements GreetingService{
    @Override
    public String greet(String name) {
        return "Hello " + name + " From Evening Greeting Service!";
    }
}
