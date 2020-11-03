package org.portfolio.instaorganize.service;

import org.portfolio.instaorganize.adapter.TaskGroupAdapter;
import org.portfolio.instaorganize.constants.ErrorCodes;
import org.portfolio.instaorganize.dto.TaskGroupDTO;
import org.portfolio.instaorganize.entity.Board;
import org.portfolio.instaorganize.entity.TaskGroup;
import org.portfolio.instaorganize.exceptions.GenericException;
import org.portfolio.instaorganize.repository.BoardRepository;
import org.portfolio.instaorganize.repository.TaskGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskGroupService extends BaseService<TaskGroupDTO> {
    @Autowired
    private TaskGroupRepository taskGroupRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<TaskGroupDTO> getAll() {
        return TaskGroupAdapter.convertEntityToDTOList(taskGroupRepository.findAll());
    }

    @Override
    public TaskGroupDTO get(UUID id) {
        return TaskGroupAdapter.convertEntityToDTO(taskGroupRepository.findById(id)
                .orElseThrow(() -> new GenericException(ErrorCodes.NOT_FOUND)));
    }

    public List<TaskGroupDTO> getTaskGroupsByBoardId(UUID boardId) {
        return taskGroupRepository.findByBoardId(boardId).stream()
                .map(TaskGroupAdapter::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TaskGroupDTO create(TaskGroupDTO taskGroupDTO) {
        TaskGroup entity = TaskGroupAdapter.convertDTOToEntity(taskGroupDTO);
        Board board = boardRepository.findById(taskGroupDTO.getBoardId())
                .orElseThrow(() -> new GenericException(ErrorCodes.NOT_FOUND));
        board.getTaskGroupList().add(entity);
        entity.setBoard(board);
        entity.setCreatedDate(Date.from(Instant.now()));
        entity.setModifiedDate(Date.from(Instant.now()));
        boardRepository.save(board);
        return TaskGroupAdapter.convertEntityToDTO(taskGroupRepository.save(entity));
    }

    @Override
    public void update(TaskGroupDTO taskGroupDTO) {
        throw new GenericException(ErrorCodes.NOT_IMPLEMENTED);
    }

    @Override
    public void delete(TaskGroupDTO taskGroupDTO) {
        TaskGroup entity = taskGroupRepository.findById(taskGroupDTO.getTaskGroupId())
                .orElseThrow(() -> new GenericException(ErrorCodes.NOT_FOUND));
        taskGroupRepository.delete(entity);
    }
}
