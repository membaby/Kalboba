package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    public NotificationService() {
    }

    public void sendNotification(String message) {
        // TODO implement here
        System.out.println("Sending notification: " + message);
    }

    public void ViewNotifications() {
        // TODO implement here
        System.out.println("Viewing notification");
    }

    public void DeleteNotification() {
        // TODO implement here
        System.out.println("Deleting notification");
    }

    public void EditNotification() {
        // TODO implement here
        System.out.println("Editing notification");
    }
}
