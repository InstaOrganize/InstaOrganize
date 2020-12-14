package org.portfolio.instaorganize.service;

import org.portfolio.instaorganize.adapter.BoardAdapter;
import org.portfolio.instaorganize.constants.MessageConstants;
import org.portfolio.instaorganize.dto.BoardDTO;
import org.portfolio.instaorganize.exceptions.GenericException;
import org.portfolio.instaorganize.entity.Board;
import org.portfolio.instaorganize.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BoardService extends BaseService<BoardDTO> {
    @Autowired
    private BoardRepository boardRepository;
    @Override
    public List<BoardDTO> getAll() {
        List<Board> entities = boardRepository.findAll();
        return entities.stream().map(BoardAdapter::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BoardDTO get(UUID id) {

        Board entity = boardRepository.findById(id)
                .orElseThrow(()->new GenericException(MessageConstants.NOT_FOUND));
        return BoardAdapter.convertEntityToDTO(entity);
    }

    @Override
    public void create(BoardDTO dto) {
        Board entity = BoardAdapter.convertDTOToEntity(dto);
        entity.setCreatedDate(Date.from(Instant.now()));
        entity.setModifiedDate(Date.from(Instant.now()));
        boardRepository.save(entity);
    }

    @Override
    public void update(BoardDTO board) {

        Board entity = boardRepository.findById(board.getBoardId())
                .orElseThrow(()->new GenericException(MessageConstants.NOT_FOUND));
        entity.setName(board.getName());
        entity.setModifiedDate(Date.from(Instant.now()));
        boardRepository.save(entity);
    }

    @Override
    public void delete(BoardDTO board) {
        Board entity = boardRepository.findById(board.getBoardId())
                .orElseThrow(()->new GenericException(MessageConstants.NOT_FOUND));
        boardRepository.delete(entity);
    }
}
