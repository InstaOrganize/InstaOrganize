package org.portfolio.instaorganize.adapter;

import org.portfolio.instaorganize.dto.BoardDTO;
import org.portfolio.instaorganize.dto.UserDTO;
import org.portfolio.instaorganize.entity.Board;
import org.portfolio.instaorganize.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter {
    public static User convertDTOToEntity(UserDTO dto) {
        User entity = new User();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setUserId(dto.getUserId());
        entity.setUserName(dto.getUserName());

        return entity;
    }

    public static UserDTO convertEntityToDTO(User entity) {
        UserDTO dto = new UserDTO();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setUserId(entity.getUserId());
        dto.setUserName(entity.getUserName());

        return dto;
    }

    public static List<UserDTO> convertEntityToDTOList(List<User> entities) {
        List<UserDTO> dtos = new ArrayList<>();
        for(User entity : entities) {
            UserDTO dto = new UserDTO();
            dto.setUserId(entity.getUserId());
            dto.setUserName(entity.getUserName());
            dto.setEmail(entity.getEmail());
            dto.setFirstName(entity.getFirstName());
            dto.setLastName(entity.getLastName());
            dtos.add(dto);
        }
        //dto.setCreatedBy(UserAdapter.convertEntityToDTO(entity.getCreatedBy()));

        return dtos;
    }
}
