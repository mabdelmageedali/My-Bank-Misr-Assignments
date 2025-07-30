package org.example;
import org.example.di.Printer;
import org.example.di.UserService;

public class Main {
    public static void main(String[] args) {
        // Constructor injection
        Printer printer = new Printer();
        UserService userService = new UserService(printer);
        userService.processUser("Mahmoud");

        // Setter injection
        UserService userService2 = new UserService(printer);
        userService2.setPrinter(new Printer());
        userService2.processUser("Mohamed");
    }
}