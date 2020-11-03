package org.portfolio.instaorganize.dto;

import java.util.List;
import java.util.UUID;

public class BoardDTO {
    private UUID boardId;
    private String name;
    private List<TaskGroupDTO> taskGroupDTOS;
    private UserDTO createdBy;

    public UUID getBoardId() {
        return boardId;
    }

    public void setBoardId(UUID boardId) {
        this.boardId = boardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskGroupDTO> getTaskGroupDTOS() {
        return taskGroupDTOS;
    }

    public void setTaskGroupDTOS(List<TaskGroupDTO> taskGroupDTOS) {
        this.taskGroupDTOS = taskGroupDTOS;
    }

    public UserDTO getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserDTO createdById) {
        this.createdBy = createdById;
    }
}
