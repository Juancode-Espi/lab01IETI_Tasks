package com.lab01IETI.task.service.impl;


import com.lab01IETI.task.entities.Task;
import com.lab01IETI.task.exception.TaskNotFoundException;
import com.lab01IETI.task.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TaskServiceHashMap implements TaskService {

    private Map<Long, Task> tasks;

    public TaskServiceHashMap(){
        tasks = new HashMap<>();
    }


    @Override
    public Task create(Task task) {
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public Task findById(Long id) {
        return tasks.get(id);
    }

    @Override
    public List<Task> getAll() {
        return tasks.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Long id) {
        if(tasks.containsKey(id)){
            tasks.remove(id);
            return tasks.containsKey(id);
        }else{
        return false;
        }
    }

    @Override
    public Task update(Task task, Long id) {
        if(tasks.containsKey(id)){
            tasks.remove(id);
            tasks.put(id,task);
            return task;
        }
        throw new TaskNotFoundException();
    }
}
