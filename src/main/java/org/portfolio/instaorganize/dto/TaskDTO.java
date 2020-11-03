package org.portfolio.instaorganize.dto;

import java.util.List;
import java.util.UUID;

public class TaskDTO {
    private UUID taskId;
    private String name;
    private String description;
    private UserDTO createdBy;
    private UserDTO modifiedBy;
    private UUID taskGroupId;
    private List<CommentDTO> commentList;

    public UUID getTaskId() {
        return taskId;
    }

    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDTO getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserDTO createdBy) {
        this.createdBy = createdBy;
    }

    public UserDTO getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(UserDTO modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public UUID getTaskGroupId() {
        return taskGroupId;
    }

    public void setTaskGroupId(UUID taskGroupId) {
        this.taskGroupId = taskGroupId;
    }

    public List<CommentDTO> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentDTO> commentList) {
        this.commentList = commentList;
    }

}
