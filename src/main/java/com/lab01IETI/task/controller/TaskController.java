package com.lab01IETI.task.controller;

import com.lab01IETI.task.dto.TaskDto;
import com.lab01IETI.task.exception.TaskNotFoundException;
import com.lab01IETI.task.mapper.TaskMapper;
import com.lab01IETI.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.ap.shaded.freemarker.log.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper mapper;

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAll(){
        List<TaskDto> response = taskService.getAll().stream()
                .map(task -> mapper.toDto(task))
                .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> findById( @PathVariable Long id){
        return new ResponseEntity<>(mapper.toDto(taskService.findById(id)),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskDto> create( @RequestBody TaskDto taskDto){
        return new ResponseEntity<>(mapper.toDto(taskService
                .create(mapper.toEntity(taskDto))),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete( @PathVariable Long id){
        return new ResponseEntity<>(taskService.deleteById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> update ( @RequestBody TaskDto taskDto, @PathVariable Long id){
        try {
            TaskDto response = mapper.toDto(taskService
                    .update(mapper.toEntity(taskDto),id));
            return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
        }catch (TaskNotFoundException ex){
            Logger.getLogger(ex.getMessage());
            return new ResponseEntity<>(new TaskDto(), HttpStatus.ACCEPTED);
        }

    }

}
