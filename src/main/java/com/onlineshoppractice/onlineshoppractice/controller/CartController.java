package com.onlineshoppractice.onlineshoppractice.controller;

import com.onlineshoppractice.onlineshoppractice.dto.CartDTO;
import com.onlineshoppractice.onlineshoppractice.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/getAllCart")
    @ResponseBody
    public List<CartDTO> getAllCart() {
        return cartService.getAllCartDTO();
    }

}
