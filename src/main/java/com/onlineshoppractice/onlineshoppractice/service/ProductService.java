package com.onlineshoppractice.onlineshoppractice.service;

import com.onlineshoppractice.onlineshoppractice.dto.ProductDTO;
import com.onlineshoppractice.onlineshoppractice.model.Product;
import com.onlineshoppractice.onlineshoppractice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public List<ProductDTO> getAllProductDTO() {
        return productRepository.findAll()
                .stream()
                .map(this::convertToProductDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO convertToProductDTO(Product product) {
        ProductDTO newProductDTO = new ProductDTO();

        newProductDTO.setProductName(product.getProductName());
        newProductDTO.setProductPrice(product.getProductPrice());
        newProductDTO.setProductType(product.getProductType());
        newProductDTO.setProductDescription(product.getProductDescription());

        return newProductDTO;
    }
}
