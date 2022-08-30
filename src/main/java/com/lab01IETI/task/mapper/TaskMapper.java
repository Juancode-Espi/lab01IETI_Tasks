package com.lab01IETI.task.mapper;

import com.lab01IETI.task.dto.TaskDto;
import com.lab01IETI.task.entities.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task toEntity(TaskDto dto);

    TaskDto toDto(Task entity);

}
