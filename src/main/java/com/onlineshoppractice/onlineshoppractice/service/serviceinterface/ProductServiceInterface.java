package com.onlineshoppractice.onlineshoppractice.service.serviceinterface;

import com.onlineshoppractice.onlineshoppractice.dto.ProductDTO;
import com.onlineshoppractice.onlineshoppractice.model.Product;

import java.util.List;

public interface ProductServiceInterface {
    void createProduct(Product newProduct);
    List<ProductDTO> getAllProductDTO();
    static ProductDTO convertToProductDTO(Product product) {
        return null;
    }
    void updateProduct(Long productId, Product updateProduct);
    void removeProduct(Long productId);
    Product findProductById(Long productId);
}
