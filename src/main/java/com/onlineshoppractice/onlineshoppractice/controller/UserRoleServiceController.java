package com.onlineshoppractice.onlineshoppractice.controller;

import com.onlineshoppractice.onlineshoppractice.dto.UserRoleDTO;
import com.onlineshoppractice.onlineshoppractice.model.UserRole;
import com.onlineshoppractice.onlineshoppractice.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class UserRoleServiceController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/getAllUserRole")
    @ResponseBody
    public List<UserRoleDTO> getAllUserRole() {
        return userRoleService.getAllUserRoleDTO();
    }

    @PostMapping("/createUserRole")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUserRole(UserRole userRole) {
        userRoleService.createUserRole(userRole);
    }
}
