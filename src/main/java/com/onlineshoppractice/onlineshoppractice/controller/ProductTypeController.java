package com.onlineshoppractice.onlineshoppractice.controller;

import com.onlineshoppractice.onlineshoppractice.dto.ProductTypeDTO;
import com.onlineshoppractice.onlineshoppractice.model.ProductType;
import com.onlineshoppractice.onlineshoppractice.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/getAllUser")
    @ResponseBody
    public List<ProductTypeDTO> getAllProductType() {
        return productTypeService.getAllProductTypeDTO();
    }

    @PostMapping("/createProductType")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProductType(@RequestBody ProductType productType) {
        productTypeService.createProductType(productType);
    }
}
