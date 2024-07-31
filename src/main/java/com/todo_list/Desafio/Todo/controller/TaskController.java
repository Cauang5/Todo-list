package com.todo_list.Desafio.Todo.controller;

import com.todo_list.Desafio.Todo.entity.Task;
import com.todo_list.Desafio.Todo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    public List<Task> create(@RequestBody Task task){
        return taskService.create(task);
    }

    @GetMapping
    public List<Task> list(){
        return taskService.list();
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable UUID id){
        return taskService.findById(id);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable UUID id, @RequestBody Task task){
        return taskService.update(id,task);
    }

    @DeleteMapping("/{id}")
    public Task delete(@PathVariable UUID id){
        return taskService.delete(id);
    }
}
