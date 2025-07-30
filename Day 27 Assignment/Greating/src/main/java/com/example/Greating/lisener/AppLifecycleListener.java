package com.example.Greating.lisener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Component
public class AppLifecycleListener {
    @EventListener(ApplicationReadyEvent.class)
    public void onAppReady() {
        System.out.println("Application is ready!");
    }
}
