package com.onlineshoppractice.onlineshoppractice.controller;

import com.onlineshoppractice.onlineshoppractice.dto.UserDTO;
import com.onlineshoppractice.onlineshoppractice.model.Address;
import com.onlineshoppractice.onlineshoppractice.model.User;
import com.onlineshoppractice.onlineshoppractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    @ResponseBody
    public List<UserDTO> getAllUser() {
        return userService.getAllUserDTO();
    }

    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(User user) {
        userService.createUser(user);
    }
}
