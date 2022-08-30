package com.lab01IETI.task.service;

import com.lab01IETI.task.entities.Task;

import java.util.List;

public interface TaskService {

    Task create( Task task );

    Task findById( Long id);

    List<Task> getAll();

    boolean deleteById(Long id);

    Task update ( Task task, Long id);
}
