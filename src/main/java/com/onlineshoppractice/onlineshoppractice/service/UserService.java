package com.onlineshoppractice.onlineshoppractice.service;

import com.onlineshoppractice.onlineshoppractice.dto.UserDTO;
import com.onlineshoppractice.onlineshoppractice.model.User;
import com.onlineshoppractice.onlineshoppractice.repository.UserRepository;
import com.onlineshoppractice.onlineshoppractice.service.serviceinterface.UserServiceInterface;
import com.onlineshoppractice.onlineshoppractice.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;
    private final CartService cartService;
    private final AddressService addressService;

    public void createUser(User newUser){
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

    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }
    public void removeUser(Long userId) {
        Optional<User> findUser = findUserById(userId);
        if (findUser.isPresent()) {
            User user = findUser.get();
            addressService.removeAddress(user.getAddress().getId());
            cartService.removeCart(user.getCart());
            userRepository.delete(user);
        }
    }
    public void updateUser(Long userId, User updateUser) {
        Optional<User> findUser = findUserById(userId);
        if (findUser.isPresent()) {
            User user = findUser.get();
            user.setFirstName(updateUser.getFirstName());
            user.setLastName(updateUser.getLastName());
            user.setEmailAddress(updateUser.getEmailAddress());
            //TODO: Encode the password for better security.
            user.setPassword(updateUser.getPassword());
            user.setUserRole(updateUser.getUserRole());
            user.setAddress(updateUser.getAddress());
            userRepository.save(user);
        }
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
