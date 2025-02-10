package com.example.taskservice.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TaskProducer {

    private static final String TOPIC = "task-notifications";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        System.out.println("Sending Message to Kafka: "+message);
        kafkaTemplate.send(TOPIC, message);
    }
}
