package com.onlineshoppractice.onlineshoppractice.service.serviceinterface;

import com.onlineshoppractice.onlineshoppractice.dto.CartDTO;
import com.onlineshoppractice.onlineshoppractice.model.Cart;
import com.onlineshoppractice.onlineshoppractice.model.User;

import java.util.List;

public interface CartServiceInterface {

    Cart createCartForUser(User assignedUser);
    List<CartDTO> getAllCartDTO();
    List<Cart> getAllCart();
}
