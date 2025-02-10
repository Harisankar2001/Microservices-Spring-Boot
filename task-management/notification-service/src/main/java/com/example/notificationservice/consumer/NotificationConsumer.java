package com.example.notificationservice.consumer;

import com.example.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @Autowired
    private NotificationService notificationService;

    @KafkaListener(topics = "task-notifications", groupId = "notification-group")
    public void listTaskNotifications(String message){
        notificationService.sendNotification(message);
    }
}
