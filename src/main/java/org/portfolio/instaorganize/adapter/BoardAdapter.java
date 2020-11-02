package org.portfolio.instaorganize.adapter;

import org.portfolio.instaorganize.dto.BoardDTO;
import org.portfolio.instaorganize.entity.Board;

public class BoardAdapter {
    public static Board convertDTOToEntity(BoardDTO dto) {
        Board board = new Board();
        board.setBoardId(dto.getBoardId());
        board.setName(dto.getName());
        board.setCreatedBy(UserAdapter.convertDTOToEntity(dto.getCreatedBy()));
        board.setBoardId(dto.getBoardId());

        return board;
    }

    public static BoardDTO convertEntityToDTO(Board entity) {
        BoardDTO dto = new BoardDTO();
        dto.setBoardId(dto.getBoardId());
        dto.setName(dto.getName());
        dto.setCreatedBy(UserAdapter.convertEntityToDTO(entity.getCreatedBy()));
        dto.setBoardId(dto.getBoardId());

        return dto;
    }
}
