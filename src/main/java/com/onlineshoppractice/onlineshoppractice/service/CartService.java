package com.onlineshoppractice.onlineshoppractice.service;

import com.onlineshoppractice.onlineshoppractice.dto.CartDTO;
import com.onlineshoppractice.onlineshoppractice.model.Cart;
import com.onlineshoppractice.onlineshoppractice.model.Product;
import com.onlineshoppractice.onlineshoppractice.model.User;
import com.onlineshoppractice.onlineshoppractice.repository.CartRepository;
import com.onlineshoppractice.onlineshoppractice.service.serviceinterface.CartServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService implements CartServiceInterface {

    private final CartRepository cartRepository;
    private final ProductService productService;

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

    public List<Cart> getAllCart() {
        return cartRepository.findAll();
    }

    public void removeCart(Cart removeCart) {
        for (Product product : removeCart.getListOfProduct()) {
            productService.addProduct(product);
        }
        cartRepository.delete(removeCart);
    }

    private CartDTO converToCartDTO(Cart cart) {
        CartDTO newCartDTO = new CartDTO();

        newCartDTO.setUser(cart.getUser());
        newCartDTO.setListOfProduct(cart.getListOfProduct());

        return newCartDTO;
    }
}
