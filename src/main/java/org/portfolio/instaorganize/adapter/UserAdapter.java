package org.portfolio.instaorganize.adapter;

import org.portfolio.instaorganize.dto.UserDTO;
import org.portfolio.instaorganize.entity.User;

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
}
