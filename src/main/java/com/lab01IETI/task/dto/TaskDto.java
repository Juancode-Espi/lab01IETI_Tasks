package com.lab01IETI.task.dto;

import com.lab01IETI.task.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long id;
    private String name;
    private String description;
    private String status;
    private Long assignedTo;
    private LocalDate dueDate;
    private LocalDate createdAt;

}
