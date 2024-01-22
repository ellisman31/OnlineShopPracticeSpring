package com.onlineshoppractice.onlineshoppractice.service.serviceinterface;

import com.onlineshoppractice.onlineshoppractice.model.ProductType;

import java.util.Optional;

public interface ProductTypeServiceInterface {
    void createProductType(ProductType newProductType);
    void removeProductType(Long productTypeId);
    void updateProductType(Long productTypeId, ProductType updateProductType);
    Optional<ProductType> findProductTypeById(Long productTypeId);
}
