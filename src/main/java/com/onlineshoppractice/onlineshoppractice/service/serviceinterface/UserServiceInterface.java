package com.onlineshoppractice.onlineshoppractice.service.serviceinterface;

import com.onlineshoppractice.onlineshoppractice.dto.UserDTO;
import com.onlineshoppractice.onlineshoppractice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    void createUser(User newUser);
    List<UserDTO> getAllUserDTO();
    void removeUser(Long userId);
    void updateUser(Long userId, User updateUser);
    Optional<User> findUserById(Long userId);
}
