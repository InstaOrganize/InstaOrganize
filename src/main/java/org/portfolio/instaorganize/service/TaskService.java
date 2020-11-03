package org.portfolio.instaorganize.service;

import org.portfolio.instaorganize.adapter.CommentAdapter;
import org.portfolio.instaorganize.adapter.TaskAdapter;
import org.portfolio.instaorganize.adapter.TaskGroupAdapter;
import org.portfolio.instaorganize.constants.ErrorCodes;
import org.portfolio.instaorganize.dto.TaskDTO;
import org.portfolio.instaorganize.entity.Task;
import org.portfolio.instaorganize.exceptions.GenericException;
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
        task.setCreatedDate(Date.from(Instant.now()));
        task.setModifiedDate(Date.from(Instant.now()));
        taskRepository.save(task);
        return TaskAdapter.convertEntityToDTO(taskRepository.save(task));
    }

    @Override
    public void update(TaskDTO taskDTO) {

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
