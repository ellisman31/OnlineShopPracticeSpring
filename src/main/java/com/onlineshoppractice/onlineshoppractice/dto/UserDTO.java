package com.onlineshoppractice.onlineshoppractice.dto;

import com.onlineshoppractice.onlineshoppractice.model.Address;
import com.onlineshoppractice.onlineshoppractice.model.Cart;
import com.onlineshoppractice.onlineshoppractice.model.UserRole;
import lombok.Data;

@Data
public class UserDTO {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private UserRole userRole;
    private Cart cart;
    private Address address;
}
