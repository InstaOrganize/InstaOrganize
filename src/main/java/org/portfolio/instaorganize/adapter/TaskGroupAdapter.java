package org.portfolio.instaorganize.adapter;

import org.portfolio.instaorganize.dto.TaskGroupDTO;
import org.portfolio.instaorganize.entity.TaskGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskGroupAdapter {
    public static TaskGroup convertDTOToEntity(TaskGroupDTO dto) {
        TaskGroup entity = new TaskGroup();
        entity.setTaskGroupId(dto.getTaskGroupId());
        entity.setName(dto.getName());
        return entity;
    }

    public static TaskGroupDTO convertEntityToDTO(TaskGroup entity) {
        TaskGroupDTO dto = new TaskGroupDTO();
        dto.setTaskGroupId(entity.getTaskGroupId());
        dto.setName(entity.getName());
        //dto.setCreatedBy(UserAdapter.convertEntityToDTO(entity.getCreatedBy()));
        if (entity.getBoard() != null)
            dto.setBoardId(entity.getBoard().getBoardId());
        if(entity.getTaskList() != null)
            dto.setTaskList(entity.getTaskList().stream()
                .map(TaskAdapter::convertEntityToDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    public static List<TaskGroupDTO> convertEntityToDTOList(List<TaskGroup> entities) {
        List<TaskGroupDTO> dtos = new ArrayList<>();
        for (TaskGroup entity : entities) {
            TaskGroupDTO dto = new TaskGroupDTO();
            dto.setTaskGroupId(entity.getTaskGroupId());
            dto.setName(entity.getName());
            if (entity.getBoard() != null)
                dto.setBoardId(entity.getBoard().getBoardId());
            dtos.add(dto);
        }
        //dto.setCreatedBy(UserAdapter.convertEntityToDTO(entity.getCreatedBy()));

        return dtos;
    }
}
