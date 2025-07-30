package com.example.core.component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService{
    private Printer printer;

    @Autowired
    public UserService(Printer printer) {
        this.printer = printer;
    }

    public void serve() {
        printer.print("UserService serving via Spring Core...");
    }
}
