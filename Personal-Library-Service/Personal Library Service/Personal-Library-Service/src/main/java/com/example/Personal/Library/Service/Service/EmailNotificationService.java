package com.example.Personal.Library.Service.Service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EmailNotificationService implements NotificationService {
    @Override
    public String sendNotification(String message) {
        return "Email Notification Sent: " + message;
    }
}
