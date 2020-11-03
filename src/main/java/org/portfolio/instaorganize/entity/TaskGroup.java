package org.portfolio.instaorganize.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class TaskGroup {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID taskGroupId;
    private String name;
    @ManyToOne
    @JoinColumn(name="created_by_id", nullable=true)
    private User createdBy;
    @ManyToOne
    @JoinColumn(name="board_id", nullable=false)
    private Board board;
    @OneToMany(mappedBy="taskGroup", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Task> taskList;
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Temporal(TemporalType.DATE)
    private Date modifiedDate;

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

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> task) {
        this.taskList = task;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
