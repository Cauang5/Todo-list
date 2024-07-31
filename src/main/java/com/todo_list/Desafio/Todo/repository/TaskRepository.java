package com.todo_list.Desafio.Todo.repository;

import com.todo_list.Desafio.Todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
