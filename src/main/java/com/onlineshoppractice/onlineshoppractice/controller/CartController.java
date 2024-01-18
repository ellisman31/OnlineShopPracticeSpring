package com.onlineshoppractice.onlineshoppractice.controller;

import com.onlineshoppractice.onlineshoppractice.dto.CartDTO;
import com.onlineshoppractice.onlineshoppractice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/getAllCart")
    @ResponseBody
    public List<CartDTO> getAllCart() {
        return cartService.getAllCartDTO();
    }

}
