package com.onlineshoppractice.onlineshoppractice.dto;

import com.onlineshoppractice.onlineshoppractice.model.User;
import lombok.Data;

import java.util.List;

@Data
public class AddressDTO {
    private String city;
    private int postalCode;
    private String streetName;
    private String streetNumber;
    private String apartmentNumber;
    private List<User> listOfUser;
}
