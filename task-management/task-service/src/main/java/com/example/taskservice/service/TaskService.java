package com.example.taskservice.service;


import com.example.taskservice.client.UserServiceClient;
import com.example.taskservice.exception.InvalidInputException;
import com.example.taskservice.exception.ResourceNotFoundException;
import com.example.taskservice.model.Task;
import com.example.taskservice.producer.TaskProducer;
import com.example.taskservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserServiceClient userServiceClient;

    @Autowired
    private TaskProducer taskProducer;


    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task saveTask(Task task){

        if(task.getTitle()==null || task.getTitle().isEmpty()){
            throw new InvalidInputException(("Task Title Cannot be Empty..."));
        }

        String userExists = userServiceClient.getUserById(task.getUserId());

        if (userExists==null){
            throw new ResourceNotFoundException("User ID "+task.getUserId()+" does not Exist!");
        }
        return taskRepository.save(task);
    }

    public List<Task> getTasksByUserId(Long userId){
        List<Task> tasks = taskRepository.findByUserId(userId);

        if(tasks.isEmpty()){
            throw new ResourceNotFoundException(("No tasks found for User Id: "+userId));
        }
        return tasks;
    }

    public void createTask(String task){
        String message = "Task Created: "+task;
        taskProducer.sendMessage(message);

    }


}
