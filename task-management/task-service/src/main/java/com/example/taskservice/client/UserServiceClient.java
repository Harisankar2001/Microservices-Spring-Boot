package com.example.taskservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-service", url = "http://localhost:8081")
public interface UserServiceClient {

    @GetMapping("/users/{id}")
    String getUserById(@PathVariable("id") Long id);
}
