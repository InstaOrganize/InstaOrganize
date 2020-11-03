package org.portfolio.instaorganize.adapter;

import org.portfolio.instaorganize.dto.BoardDTO;
import org.portfolio.instaorganize.entity.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BoardAdapter {
    public static Board convertDTOToEntity(BoardDTO dto) {
        Board board = new Board();
        board.setBoardId(dto.getBoardId());
        board.setName(dto.getName());
        return board;
    }

    public static BoardDTO convertEntityToDTO(Board entity) {
        BoardDTO dto = new BoardDTO();
        dto.setBoardId(entity.getBoardId());
        dto.setName(entity.getName());
        if(entity.getTaskGroupList() != null)
            dto.setTaskGroupDTOS(entity.getTaskGroupList().stream()
                    .map(TaskGroupAdapter::convertEntityToDTO)
                    .collect(Collectors.toList()));
        //dto.setCreatedBy(UserAdapter.convertEntityToDTO(entity.getCreatedBy()));

        return dto;
    }
    public static List<BoardDTO> convertEntityToDTOList(List<Board> entities) {
        List<BoardDTO> dtos = new ArrayList<>();
        for(Board entity : entities) {
            BoardDTO dto = new BoardDTO();
            dto.setBoardId(entity.getBoardId());
            dto.setName(entity.getName());
            dtos.add(dto);
        }
        //dto.setCreatedBy(UserAdapter.convertEntityToDTO(entity.getCreatedBy()));

        return dtos;
    }
}
