package com.onlineshoppractice.onlineshoppractice.controller;

import com.onlineshoppractice.onlineshoppractice.dto.UserDTO;
import com.onlineshoppractice.onlineshoppractice.model.User;
import com.onlineshoppractice.onlineshoppractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/getAllUser")
    @ResponseBody
    public List<UserDTO> getAllUser() {
        return userService.getAllUserDTO();
    }

    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }
}
