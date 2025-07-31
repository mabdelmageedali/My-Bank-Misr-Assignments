package com.example.Personal.Library.Service.Service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class MorningGreetingService implements GreetingService {

    @Override
    public String greet(String name) {
        return "Hello " + name + " From Morning Greeting Service!";
    }
}
