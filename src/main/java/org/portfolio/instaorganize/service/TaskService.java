package org.portfolio.instaorganize.service;

import org.portfolio.instaorganize.adapter.CommentAdapter;
import org.portfolio.instaorganize.adapter.TaskAdapter;
import org.portfolio.instaorganize.adapter.TaskGroupAdapter;
import org.portfolio.instaorganize.constants.ErrorCodes;
import org.portfolio.instaorganize.dto.TaskDTO;
import org.portfolio.instaorganize.entity.Board;
import org.portfolio.instaorganize.entity.Task;
import org.portfolio.instaorganize.entity.TaskGroup;
import org.portfolio.instaorganize.exceptions.GenericException;
import org.portfolio.instaorganize.repository.TaskGroupRepository;
import org.portfolio.instaorganize.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskService extends BaseService<TaskDTO> {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskGroupRepository taskGroupRepository;

    @Override
    public List<TaskDTO> getAll() {
        return TaskAdapter.convertEntityToDTOList(taskRepository.findAll());
    }

    @Override
    public TaskDTO get(UUID id) {
        return TaskAdapter.convertEntityToDTO(taskRepository.findById(id)
                .orElseThrow(() -> new GenericException(ErrorCodes.NOT_FOUND)));
    }

    @Override
    public TaskDTO create(TaskDTO taskDTO) {
        Task task = TaskAdapter.convertDTOToEntity(taskDTO);
        TaskGroup taskGroup = taskGroupRepository.findById(taskDTO.getTaskGroupId())
                .orElseThrow(() -> new GenericException(ErrorCodes.NOT_FOUND));
        task.setCreatedDate(Date.from(Instant.now()));
        task.setModifiedDate(Date.from(Instant.now()));
        taskGroup.getTaskList().remove(task);
        taskGroup.getTaskList().add(task);
        task.setTaskGroup(taskGroup);
        taskGroupRepository.save(taskGroup);
        return TaskAdapter.convertEntityToDTO(taskRepository.save(task));
    }

    @Override
    public void update(TaskDTO taskDTO) {
    }

    public TaskDTO updateTaskBoard(UUID taskId, UUID taskGroupId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new GenericException(ErrorCodes.NOT_FOUND));
        TaskGroup newTaskGroup = taskGroupRepository.findById(taskGroupId)
                .orElseThrow(() -> new GenericException(ErrorCodes.NOT_FOUND));
        newTaskGroup.getTaskList().remove(task);
        newTaskGroup.getTaskList().add(task);
        task.setTaskGroup(newTaskGroup);
        return TaskAdapter.convertEntityToDTO(taskRepository.save(task));
    }

    @Override
    public void delete(TaskDTO taskDTO) {
        Task entity = taskRepository.findById(taskDTO.getTaskId())
                .orElseThrow(() -> new GenericException(ErrorCodes.NOT_FOUND));
        taskRepository.delete(entity);
    }

    public List<TaskDTO> getTaskByTaskGroupId(UUID taskGroupId) {
        return taskRepository.findByBoardId(taskGroupId).stream()
                .map(TaskAdapter::convertEntityToDTO)
                .collect(Collectors.toList());
    }
}
