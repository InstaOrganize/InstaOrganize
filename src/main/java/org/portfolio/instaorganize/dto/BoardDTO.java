package org.portfolio.instaorganize.dto;

import org.hibernate.annotations.GenericGenerator;
import org.portfolio.instaorganize.model.User;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

public class BoardDTO {
    private UUID boardId;
    private String name;
    private UserDTO createdById;

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

    public UserDTO getCreatedById() {
        return createdById;
    }

    public void setCreatedById(UserDTO createdById) {
        this.createdById = createdById;
    }
}
