package org.portfolio.instaorganize.adapter;

import org.portfolio.instaorganize.dto.TaskDTO;
import org.portfolio.instaorganize.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskAdapter {
    public static Task convertDTOToEntity(TaskDTO dto) {
        Task entity = new Task();
        entity.setTaskId(dto.getTaskId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    public static TaskDTO convertEntityToDTO(Task entity) {
        TaskDTO dto = new TaskDTO();
        dto.setTaskId(entity.getTaskId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        //dto.setCreatedBy(UserAdapter.convertEntityToDTO(entity.getCreatedBy()));
        //dto.setModifiedBy(UserAdapter.convertEntityToDTO(entity.getModifiedBy()));
        if (entity.getTaskGroup() == null)
            dto.setTaskGroupId(entity.getTaskGroup().getTaskGroupId());
        if (entity.getCommentList() != null)
            dto.setCommentList(entity.getCommentList().stream()
                    .map(CommentAdapter::convertEntityToDTO)
                    .collect(Collectors.toList()));
        return dto;
    }

    public static List<TaskDTO> convertEntityToDTOList(List<Task> entities) {
        List<TaskDTO> dtos = new ArrayList<>();
        for (Task entity : entities) {
            TaskDTO dto = new TaskDTO();
            dto.setTaskId(entity.getTaskId());
            dto.setName(entity.getName());
            dto.setDescription(entity.getDescription());
            if (entity.getTaskGroup() != null)
                dto.setTaskGroupId(entity.getTaskGroup().getTaskGroupId());
            dtos.add(dto);
        }
        //dto.setCreatedBy(UserAdapter.convertEntityToDTO(entity.getCreatedBy()));

        return dtos;
    }
}
