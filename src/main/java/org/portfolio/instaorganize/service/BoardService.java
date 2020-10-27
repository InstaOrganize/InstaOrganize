package org.portfolio.instaorganize.service;

import org.portfolio.instaorganize.constants.MessageConstants;
import org.portfolio.instaorganize.exceptions.GenericException;
import org.portfolio.instaorganize.model.Board;
import org.portfolio.instaorganize.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService extends BaseService<Board> {
    @Autowired
    private BoardRepository boardRepository;
    @Override
    public List<Board> getAll() {
        return boardRepository.findAll();
    }

    @Override
    public Board get(UUID id) {
        return boardRepository.findById(id)
                .orElseThrow(()->new GenericException(MessageConstants.NOT_FOUND));
    }

    @Override
    public void create(Board board) {
        board.setCreatedDate(Date.from(Instant.now()));
        board.setModifiedDate(Date.from(Instant.now()));
        boardRepository.save(board);
    }

    @Override
    public void update(Board board) {

        Board entity = boardRepository.findById(board.getBoardId())
                .orElseThrow(()->new GenericException(MessageConstants.NOT_FOUND));
        entity.setName(board.getName());
        boardRepository.save(entity);
    }

    @Override
    public void delete(Board board) {
        Board entity = boardRepository.findById(board.getBoardId())
                .orElseThrow(()->new GenericException(MessageConstants.NOT_FOUND));
        boardRepository.delete(entity);
    }
}
