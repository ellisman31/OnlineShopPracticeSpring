package com.onlineshoppractice.onlineshoppractice.service;

import com.onlineshoppractice.onlineshoppractice.dto.CartDTO;
import com.onlineshoppractice.onlineshoppractice.model.Cart;
import com.onlineshoppractice.onlineshoppractice.model.Product;
import com.onlineshoppractice.onlineshoppractice.model.User;
import com.onlineshoppractice.onlineshoppractice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    //It would be not necessary to create request in the Controller for Cart creation.
    public Cart createCartForUser(User assignedUser) {
        if (assignedUser != null) {
            Cart newCart = new Cart(assignedUser, new ArrayList<>());
            cartRepository.save(newCart);
            return newCart;
        }
        return null;
    }

    public List<CartDTO> getAllCartDTO() {
        return cartRepository.findAll()
                .stream()
                .map(this::converToCartDTO)
                .collect(Collectors.toList());
    }

    private CartDTO converToCartDTO(Cart cart) {
        CartDTO newCartDTO = new CartDTO();

        newCartDTO.setUser(cart.getUser());
        newCartDTO.setListOfProduct(cart.getListOfProduct());

        return newCartDTO;
    }
}
