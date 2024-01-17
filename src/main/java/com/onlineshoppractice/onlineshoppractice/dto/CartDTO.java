package com.onlineshoppractice.onlineshoppractice.dto;

import com.onlineshoppractice.onlineshoppractice.model.Product;
import com.onlineshoppractice.onlineshoppractice.model.User;
import lombok.Data;

import java.util.List;

@Data
public class CartDTO {
    private User user;
    private List<Product> listOfProduct;
}
