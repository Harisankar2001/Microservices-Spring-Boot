package com.example.notificationservice.controller;


import com.example.notificationservice.model.Notifications;
import com.example.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/send")
    public String sendNotification(@RequestParam("message") String message){
//        notificationService.sendNotification(message);

        return "Notification Received Successfully as: "+message;
    }

    @GetMapping("/receive")
    public List<Notifications> getAllNotifications(){
        return notificationService.receiveNotification();
    }


}
