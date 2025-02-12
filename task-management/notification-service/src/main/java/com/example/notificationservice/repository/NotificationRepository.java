package com.example.notificationservice.repository;

import com.example.notificationservice.model.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notifications, Long> {
}
