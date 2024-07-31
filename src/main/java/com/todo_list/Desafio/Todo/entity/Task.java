package com.todo_list.Desafio.Todo.entity;

import com.todo_list.Desafio.Todo.entity.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_TASK")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;
    private String description;
    private int priority;
    //@Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate date;

}
