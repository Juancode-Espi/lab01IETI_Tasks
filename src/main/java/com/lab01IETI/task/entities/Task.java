package com.lab01IETI.task.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private Long id;
    private String name;
    private String description;
    private Status status;
    private Long assignedTo;
    private LocalDate dueDate;
    private LocalDate createdAt;

}
