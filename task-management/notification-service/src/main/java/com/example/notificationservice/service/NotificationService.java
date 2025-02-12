package com.example.notificationservice.service;

import com.example.notificationservice.model.Notifications;
import com.example.notificationservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notifications> receiveNotification(){
        return notificationRepository.findAll();
    }
}
