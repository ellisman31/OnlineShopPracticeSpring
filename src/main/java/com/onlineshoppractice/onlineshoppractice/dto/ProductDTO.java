package com.onlineshoppractice.onlineshoppractice.dto;

import com.onlineshoppractice.onlineshoppractice.model.ProductType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private String productName;
    private BigDecimal productPrice;
    private ProductType productType;
    private String productDescription;
}
