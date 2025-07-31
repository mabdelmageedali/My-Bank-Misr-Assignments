package com.example.Personal.Library.Service.Controller;


import com.example.Personal.Library.Service.Service.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    private final NotificationService primaryNotificationService;

    private final NotificationService smsNotificationService;

    public NotificationController(
            NotificationService primaryNotificationService,
            @Qualifier("sms") NotificationService smsNotificationService) {
        this.primaryNotificationService = primaryNotificationService;
        this.smsNotificationService = smsNotificationService;
    }

    @GetMapping("/email")
    public String sendEmailNotification() {
        return primaryNotificationService.sendNotification("Hello from Email!");
    }

    @GetMapping("/sms")
    public String sendSmsNotification() {
        return smsNotificationService.sendNotification("Hello from SMS!");
    }
}
