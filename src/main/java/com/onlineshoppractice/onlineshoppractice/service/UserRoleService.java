package com.onlineshoppractice.onlineshoppractice.service;

import com.onlineshoppractice.onlineshoppractice.dto.UserRoleDTO;
import com.onlineshoppractice.onlineshoppractice.model.User;
import com.onlineshoppractice.onlineshoppractice.model.UserRole;
import com.onlineshoppractice.onlineshoppractice.model.type.UserRolePattern;
import com.onlineshoppractice.onlineshoppractice.repository.UserRepository;
import com.onlineshoppractice.onlineshoppractice.repository.UserRoleRepository;
import com.onlineshoppractice.onlineshoppractice.service.serviceinterface.UserRoleServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserRoleService implements UserRoleServiceInterface {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;

    public void createUserRole(UserRole newUserRole) {
        userRoleRepository.save(newUserRole);
    }

    public List<UserRoleDTO> getAllUserRoleDTO() {
        return userRoleRepository.findAll()
                .stream()
                .map(this::convertToUserRoleDTO)
                .collect(Collectors.toList());
    }

    //Remove User Role and modify User Role for existing Users to Default.
    public void removeUserRole(Long userRoleId) {
        Optional<UserRole> removeUserRole = findUserRoleById(userRoleId);
        if (removeUserRole.isPresent()) {
            userRoleRepository.delete(removeUserRole.get());
            List<User> usersWithTheFindUserRole = userRepository.findAll().stream()
                    .filter(user -> user.getUserRole().equals(removeUserRole.get()))
                    .toList();
            Optional<UserRole> defaultUserRole = userRoleRepository.findByOnlineShopUserRole(UserRolePattern.MEMBER);
            if (!usersWithTheFindUserRole.isEmpty() && defaultUserRole.isPresent())
                for (User user: usersWithTheFindUserRole) {
                    user.setUserRole(defaultUserRole.get());
                    userRepository.save(user);
                }
        }
    }

    public void updateUserRole(Long userRoleId, UserRole updateUserRole) {
        Optional<UserRole> findUserRole = findUserRoleById(userRoleId);
        if (findUserRole.isPresent() && updateUserRole != null) {
            UserRole userRole = findUserRole.get();
            userRole.setUser(updateUserRole.getUser());
            userRole.setOnlineShopUserRole(updateUserRole.getOnlineShopUserRole());
            userRoleRepository.save(userRole);
        }
    }

    private UserRoleDTO convertToUserRoleDTO(UserRole userRole) {
        UserRoleDTO newUserRoleDTO = new UserRoleDTO();

        newUserRoleDTO.setUserRolePattern(userRole.getOnlineShopUserRole());

        return newUserRoleDTO;
    }

    public Optional<UserRole> findUserRoleById(Long userRoleId) {
        return userRoleRepository.findById(userRoleId);
    }

}
