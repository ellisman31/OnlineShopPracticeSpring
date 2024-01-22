package com.onlineshoppractice.onlineshoppractice.service.serviceinterface;

import com.onlineshoppractice.onlineshoppractice.dto.UserRoleDTO;
import com.onlineshoppractice.onlineshoppractice.model.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserRoleServiceInterface {
    void createUserRole(UserRole newUserRole);
    List<UserRoleDTO> getAllUserRoleDTO();
    void removeUserRole(Long userRoleId);
    void updateUserRole(Long userRoleId, UserRole updateUserRole);
    Optional<UserRole> findUserRoleById(Long userRoleId);
}
