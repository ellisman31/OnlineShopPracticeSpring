package com.onlineshoppractice.onlineshoppractice.service;

import com.onlineshoppractice.onlineshoppractice.dto.UserRoleDTO;
import com.onlineshoppractice.onlineshoppractice.model.UserRole;
import com.onlineshoppractice.onlineshoppractice.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public void createProduct(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    public List<UserRoleDTO> getAllUserRoleDTO() {
        return userRoleRepository.findAll()
                .stream()
                .map(this::convertToUserRoleDTO)
                .collect(Collectors.toList());
    }

    private UserRoleDTO convertToUserRoleDTO(UserRole userRole) {
        UserRoleDTO newUserRoleDTO = new UserRoleDTO();

        newUserRoleDTO.setUserRoleType(userRole.getOnlineShopUserRole());

        return newUserRoleDTO;
    }

}
