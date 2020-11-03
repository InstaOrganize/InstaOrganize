package org.portfolio.instaorganize.service;

import org.portfolio.instaorganize.adapter.BoardAdapter;
import org.portfolio.instaorganize.constants.ErrorCodes;
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
        return BoardAdapter.convertEntityToDTOList(entities);
    }

    @Override
    public BoardDTO get(UUID id) {

        Board entity = boardRepository.findById(id)
                .orElseThrow(()->new GenericException(ErrorCodes.NOT_FOUND));
        return BoardAdapter.convertEntityToDTO(entity);
    }

    @Override
    public BoardDTO create(BoardDTO dto) {
        Board entity = BoardAdapter.convertDTOToEntity(dto);
        entity.setCreatedDate(Date.from(Instant.now()));
        entity.setModifiedDate(Date.from(Instant.now()));
        return BoardAdapter.convertEntityToDTO(boardRepository.save(entity));
    }

    @Override
    public void update(BoardDTO board) {

        throw new GenericException(ErrorCodes.NOT_IMPLEMENTED);
    }

    @Override
    public void delete(BoardDTO board) {
        Board entity = boardRepository.findById(board.getBoardId())
                .orElseThrow(()->new GenericException(ErrorCodes.NOT_FOUND));
        boardRepository.delete(entity);
    }
}
