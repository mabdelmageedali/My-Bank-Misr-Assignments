package com.example.core.component;
import org.springframework.stereotype.Component;

@Component
class Printer {
    public void print(String message) {
        System.out.println(message);
    }
}