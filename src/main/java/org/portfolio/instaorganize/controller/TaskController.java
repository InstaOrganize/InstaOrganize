package org.portfolio.instaorganize.controller;

import org.portfolio.instaorganize.dto.CommentDTO;
import org.portfolio.instaorganize.dto.TaskDTO;
import org.portfolio.instaorganize.dto.TaskGroupDTO;
import org.portfolio.instaorganize.service.CommentService;
import org.portfolio.instaorganize.service.TaskGroupService;
import org.portfolio.instaorganize.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private CommentService commentService;
    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO task) {
        taskService.create(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable String id) {
        return new ResponseEntity<>(taskService.get(UUID.fromString(id)),HttpStatus.OK);
    }

    @GetMapping("{id}/comments")
    public ResponseEntity<List<CommentDTO>> getCommentsByTask(@PathVariable String id) {
        return new ResponseEntity<>(commentService.getCommentsByTaskId(UUID.fromString(id)),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TaskDTO> updateBoard(@RequestBody TaskDTO task) {
        taskService.create(task);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteTask(@RequestBody TaskDTO task) {
        taskService.delete(task);
        return new ResponseEntity(HttpStatus.OK);
    }
}
