package org.portfolio.instaorganize.adapter;

import org.portfolio.instaorganize.dto.CommentDTO;
import org.portfolio.instaorganize.entity.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentAdapter {
    public static Comment convertDTOToEntity(CommentDTO dto) {
        Comment entity = new Comment();
        entity.setCommentId(dto.getCommentId());
        entity.setText(dto.getText());

        return entity;
    }

    public static CommentDTO convertEntityToDTO(Comment entity) {
        CommentDTO dto = new CommentDTO();
        dto.setCommentId(entity.getCommentId());
        dto.setText(entity.getText());
        //dto.setCreatedBy(UserAdapter.convertEntityToDTO(entity.getCreatedBy()));
        if(entity.getTask()!=null)
            dto.setTaskId(entity.getTask().getTaskId());
        return dto;
    }
    public static List<CommentDTO> convertEntityToDTOList(List<Comment> entities) {
        List<CommentDTO> dtos = new ArrayList<>();
        for (Comment entity : entities) {
            CommentDTO dto = new CommentDTO();
            dto.setCommentId(entity.getCommentId());
            dto.setText(entity.getText());
            if (entity.getTask() != null)
                dto.setTaskId(entity.getTask().getTaskId());
            dtos.add(dto);
        }
        //dto.setCreatedBy(UserAdapter.convertEntityToDTO(entity.getCreatedBy()));

        return dtos;
    }
}
