package com.example.notificationservice.consumer;

import com.example.notificationservice.model.Notifications;
import com.example.notificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class NotificationConsumer {

    @Autowired
    private NotificationRepository notificationRepository;

    @KafkaListener(topics = "task-notifications", groupId = "notification-group")
    public List<Notifications> listTaskNotifications(String message){

        Notifications notifications = new Notifications();
        notifications.setMessages(message);
        List<Notifications> notifications1 = new ArrayList<>();
        notifications1.add(notifications);
        notificationRepository.save(notifications);

        return notifications1;
    }
}
