package com.lab01IETI.task.exception;

public class TaskNotFoundException extends RuntimeException{
    private static final String TASK_NOT_FOUND = "TASK NOT FOUND";

    public TaskNotFoundException(){
        super(TASK_NOT_FOUND);
    }
}
