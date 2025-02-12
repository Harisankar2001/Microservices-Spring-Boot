package com.example.notificationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String messages;

    public Notifications(Long id, String messages) {
        this.id = id;
        this.messages = messages;
    }

    public Notifications() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
