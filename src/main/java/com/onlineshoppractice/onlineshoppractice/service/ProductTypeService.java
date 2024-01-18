package com.onlineshoppractice.onlineshoppractice.service;

import com.onlineshoppractice.onlineshoppractice.dto.ProductTypeDTO;
import com.onlineshoppractice.onlineshoppractice.model.ProductType;
import com.onlineshoppractice.onlineshoppractice.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    public void createProductType(ProductType newProductType) {
        productTypeRepository.save(newProductType);
    }

    public List<ProductTypeDTO> getAllProductTypeDTO() {
        return productTypeRepository.findAll()
                .stream()
                .map(this::convertToProductTypeDTO)
                .collect(Collectors.toList());
    }

    private ProductTypeDTO convertToProductTypeDTO(ProductType productType) {
        ProductTypeDTO newProductTypeDTO = new ProductTypeDTO();

        newProductTypeDTO.setProductType(productType.getProductType());

        return newProductTypeDTO;
    }

}
