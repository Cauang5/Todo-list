package com.todo_list.Desafio.Todo.service;

import com.todo_list.Desafio.Todo.entity.Task;
import com.todo_list.Desafio.Todo.repository.TaskRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

   private TaskRepository taskRepository;

   public TaskService(TaskRepository taskRepository){
      this.taskRepository = taskRepository;
   }

   public List<Task> create(Task task){
      taskRepository.save(task);
      return list();
   }

   public List<Task> list(){
       Sort sort = Sort.by("priority").descending().and(
               Sort.by("title").ascending()
       );
      return taskRepository.findAll(sort);
   }

   public Task findById(UUID id){
      return taskRepository.findById(id)
              .orElseThrow(() -> new RuntimeException("Task not found with id: " +id));
   }

   public Task update(UUID id, Task newTask){
      return taskRepository.findById(id)
              .map(task -> {
                 task.setTitle(newTask.getTitle());
                 task.setDescription(newTask.getDescription());
                 task.setPriority(newTask.getPriority());
                 task.setStatus(newTask.getStatus());
                 task.setDate(newTask.getDate());
                 return taskRepository.save(task);
              })
              .orElseThrow(() -> new RuntimeException("Task not found with id: " +id));
   }

   public Task delete(UUID id){
      Task taskToDelete = findById(id);
      taskRepository.deleteById(id);
      return taskToDelete;
   }

}
