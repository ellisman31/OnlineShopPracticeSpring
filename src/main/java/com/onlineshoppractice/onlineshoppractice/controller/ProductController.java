package com.onlineshoppractice.onlineshoppractice.controller;

import com.onlineshoppractice.onlineshoppractice.dto.ProductDTO;
import com.onlineshoppractice.onlineshoppractice.model.Product;
import com.onlineshoppractice.onlineshoppractice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getAllProduct")
    @ResponseBody
    public List<ProductDTO> getAllProduct() {
        return productService.getAllProductDTO();
    }

    @PostMapping("/createProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }
}
