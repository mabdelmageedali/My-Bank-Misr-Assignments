package org.example.di;

public class UserService {
    private final Printer printer;

    //Constructor injection
    public UserService(Printer printer) {
        this.printer = printer;
    }
    private Printer setterPrinter;

    //Setter injection
    public void setPrinter(Printer printer) {
        this.setterPrinter = printer;
    }
    public void processUser(String username) {
        printer.print("Processing user: " + username);
        if (setterPrinter != null) {
            setterPrinter.print("Secondary processing for: " + username);
        }
    }
}
