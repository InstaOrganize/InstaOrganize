package org.portfolio.instaorganize.dto;

import java.util.UUID;

public class BoardDTO {
    private UUID boardId;
    private String name;
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

    public UserDTO getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserDTO createdById) {
        this.createdBy = createdById;
    }
}
