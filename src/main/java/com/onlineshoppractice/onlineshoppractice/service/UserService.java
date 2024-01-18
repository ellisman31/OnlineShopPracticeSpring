package com.onlineshoppractice.onlineshoppractice.service;

import com.onlineshoppractice.onlineshoppractice.dto.UserDTO;
import com.onlineshoppractice.onlineshoppractice.model.User;
import com.onlineshoppractice.onlineshoppractice.repository.CartRepository;
import com.onlineshoppractice.onlineshoppractice.repository.UserRepository;
import com.onlineshoppractice.onlineshoppractice.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartService cartService;

    public void createUser(User newUser) {
        newUser.setCart(cartService.createCartForUser(newUser));
        newUser.setRegistrationDate(Util.getCurrentDate());
        userRepository.save(newUser);
    }

    public List<UserDTO> getAllUserDTO() {
        return userRepository.findAll()
                .stream()
                .map(this::converToUserDTO)
                .collect(Collectors.toList());
    }

    private UserDTO converToUserDTO(User user) {
        UserDTO newUserDTO = new UserDTO();

        newUserDTO.setFirstName(user.getFirstName());
        newUserDTO.setLastName(user.getLastName());
        newUserDTO.setEmailAddress(user.getEmailAddress());
        newUserDTO.setUserRole(user.getUserRole());
        newUserDTO.setCart(user.getCart());
        newUserDTO.setAddress(user.getAddress());

        return newUserDTO;
    }

}
