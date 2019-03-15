package org.securme.jwt.web;


import org.securme.jwt.dao.TaskRepository;
import org.securme.jwt.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskRestController  {

    @Autowired
    private TaskRepository taskRepository;


    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String Hello(){
        System.out.println("*********** ADD Hello");
        return "Hello";
    }

    @PostMapping("/task")
    public Task save(@RequestBody Task task){
        System.out.println("*********** ADD TASK");
        return taskRepository.save(task);
    }

    @GetMapping("/tasks")
    public List<Task> listTasks(){
        System.out.println("*********** List TASKS");
        return taskRepository.findAll();
    }




}
