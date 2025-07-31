package com.example.Personal.Library.Service.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("sms")
public class SmsNotificationService implements NotificationService {

    @Override
    public String sendNotification(String message) {
        return "SMS Notification Sent: " + message;
    }
}
