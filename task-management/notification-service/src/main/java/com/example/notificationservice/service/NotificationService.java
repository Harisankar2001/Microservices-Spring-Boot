package com.example.notificationservice.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendNotification(String message){
        System.out.println("Received Notification: "+message);
    }
}
