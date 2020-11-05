package org.portfolio.instaorganize.service;

import org.portfolio.instaorganize.adapter.BoardAdapter;
import org.portfolio.instaorganize.adapter.CommentAdapter;
import org.portfolio.instaorganize.adapter.TaskAdapter;
import org.portfolio.instaorganize.constants.ErrorCodes;
import org.portfolio.instaorganize.dto.CommentDTO;
import org.portfolio.instaorganize.entity.Comment;
import org.portfolio.instaorganize.entity.Task;
import org.portfolio.instaorganize.exceptions.GenericException;
import org.portfolio.instaorganize.repository.CommentRepository;
import org.portfolio.instaorganize.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CommentService extends BaseService<CommentDTO> {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<CommentDTO> getAll() {
        return CommentAdapter.convertEntityToDTOList(commentRepository.findAll());
    }

    @Override
    public CommentDTO get(UUID id) {
        return CommentAdapter.convertEntityToDTO(commentRepository.findById(id)
                .orElseThrow(() -> new GenericException(ErrorCodes.NOT_FOUND)));
    }

    @Override
    public CommentDTO create(CommentDTO commentDTO) {
        Comment entity = CommentAdapter.convertDTOToEntity(commentDTO);
        Task task = taskRepository.findById(commentDTO.getTaskId())
                .orElseThrow(() -> new GenericException(ErrorCodes.NOT_FOUND));
        entity.setCreatedDate(Date.from(Instant.now()));
        entity.setModifiedDate(Date.from(Instant.now()));
        task.getCommentList().remove(entity);
        task.getCommentList().add(entity);
        entity.setTask(task);
        taskRepository.save(task);
        return CommentAdapter.convertEntityToDTO(commentRepository.save(entity));
    }

    @Override
    public void update(CommentDTO commentDTO) {
        throw new GenericException(ErrorCodes.NOT_IMPLEMENTED);
    }

    @Override
    public void delete(CommentDTO commentDTO) {
        Comment entity = commentRepository.findById(commentDTO.getCommentId())
                .orElseThrow(() -> new GenericException(ErrorCodes.NOT_FOUND));
        commentRepository.delete(entity);

    }

    public List<CommentDTO> getCommentsByTaskId(UUID taskId) {
        return commentRepository.findByTaskId(taskId).stream()
                .map(CommentAdapter::convertEntityToDTO)
                .collect(Collectors.toList());
    }
}
