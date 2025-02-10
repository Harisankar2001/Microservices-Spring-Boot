package com.example.taskservice.controller;


import com.example.taskservice.model.Task;
import com.example.taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PostMapping
    public ResponseEntity<Task> saveTask(@RequestBody Task task){
        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.CREATED);
    }

    @GetMapping({"/users/{userId}"})
    public List<Task> getTaskByUser(@PathVariable("userId") Long userId){
        return taskService.getTasksByUserId(userId);
    }

    @PostMapping("/create")
    public String createTask(@RequestParam("taskName") String taskName){
        taskService.createTask(taskName);
        return "Task Created Successfully";
    }
}
