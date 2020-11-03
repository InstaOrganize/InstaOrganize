package org.portfolio.instaorganize.dto;

import org.portfolio.instaorganize.entity.Task;

import java.util.List;
import java.util.UUID;

public class TaskGroupDTO {

    private UUID taskGroupId;
    private String name;
    private UserDTO createdBy;
    private UUID boardId;
    private List<TaskDTO> taskList;

    public UUID getTaskGroupId() {
        return taskGroupId;
    }

    public void setTaskGroupId(UUID taskGroupId) {
        this.taskGroupId = taskGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDTO getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserDTO createdBy) {
        this.createdBy = createdBy;
    }

    public UUID getBoardId() {
        return boardId;
    }

    public void setBoardId(UUID boardId) {
        this.boardId = boardId;
    }

    public List<TaskDTO> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<TaskDTO> taskList) {
        this.taskList = taskList;
    }
}
