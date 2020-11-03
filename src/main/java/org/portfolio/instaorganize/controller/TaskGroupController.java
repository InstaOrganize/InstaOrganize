package org.portfolio.instaorganize.controller;

import org.portfolio.instaorganize.dto.BoardDTO;
import org.portfolio.instaorganize.dto.TaskDTO;
import org.portfolio.instaorganize.dto.TaskGroupDTO;
import org.portfolio.instaorganize.service.BoardService;
import org.portfolio.instaorganize.service.TaskGroupService;
import org.portfolio.instaorganize.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("task-groups")
public class TaskGroupController {
    @Autowired
    private TaskGroupService taskGroupService;
    @Autowired
    private TaskService taskService;
    @PostMapping
    public ResponseEntity<TaskGroupDTO> createTaskGroup(@RequestBody TaskGroupDTO taskGroup) {
        return new ResponseEntity<>(taskGroupService.create(taskGroup), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskGroupDTO>> getAllTaskGroups() {
        return new ResponseEntity<>(taskGroupService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskGroupDTO> getTaskGroup(@PathVariable String id) {
        return new ResponseEntity<>(taskGroupService.get(UUID.fromString(id)),HttpStatus.OK);
    }

    @GetMapping("{id}/tasks")
    public ResponseEntity<List<TaskDTO>> getTasksInTaskGroup(@PathVariable String id) {
        return new ResponseEntity<>(taskService.getTaskByTaskGroupId(UUID.fromString(id)),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TaskGroupDTO> updateTaskGroup(@RequestBody TaskGroupDTO taskGroup) {
        taskGroupService.create(taskGroup);
        return new ResponseEntity<>(taskGroup, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteTaskGroup(@RequestBody TaskGroupDTO taskGroup) {
        taskGroupService.delete(taskGroup);
        return new ResponseEntity(HttpStatus.OK);
    }
}
