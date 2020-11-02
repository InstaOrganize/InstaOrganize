package org.portfolio.instaorganize.service;

import org.portfolio.instaorganize.adapter.UserAdapter;
import org.portfolio.instaorganize.constants.MessageConstants;
import org.portfolio.instaorganize.dto.UserDTO;
import org.portfolio.instaorganize.entity.User;
import org.portfolio.instaorganize.exceptions.GenericException;
import org.portfolio.instaorganize.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService extends BaseService<UserDTO> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAll() {
        List<User> entities = userRepository.findAll();
        return entities.stream().map(UserAdapter::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO get(UUID id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new GenericException(MessageConstants.NOT_FOUND));
        return UserAdapter.convertEntityToDTO(entity);
    }

    @Override
    public void create(UserDTO userDTO) {
        User entity = UserAdapter.convertDTOToEntity(userDTO);
        entity.setCreatedDate(Date.from(Instant.now()));
        entity.setModifiedDate(Date.from(Instant.now()));
        userRepository.save(entity);
    }

    @Override
    public void update(UserDTO userDTO) {
        User entity = userRepository.findById(userDTO.getUserId())
                .orElseThrow(() -> new GenericException(MessageConstants.NOT_FOUND));
        entity.setFirstName(userDTO.getFirstName());
        entity.setLastName(userDTO.getLastName());
        entity.setEmail(userDTO.getEmail());
        entity.setModifiedDate(Date.from(Instant.now()));
        userRepository.save(entity);
    }

    @Override
    public void delete(UserDTO userDTO) {
        User entity = userRepository.findById(userDTO.getUserId())
                .orElseThrow(() -> new GenericException(MessageConstants.NOT_FOUND));
        userRepository.delete(entity);
    }

    public UserDTO findUserByUserName(String userName) {
        User user = userRepository.findUserByUserName(userName).orElse(null);
        return user != null ? UserAdapter.convertEntityToDTO(user) : null;
    }
}
