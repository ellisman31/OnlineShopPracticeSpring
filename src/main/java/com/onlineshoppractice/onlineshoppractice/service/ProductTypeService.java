package com.onlineshoppractice.onlineshoppractice.service;

import com.onlineshoppractice.onlineshoppractice.dto.ProductTypeDTO;
import com.onlineshoppractice.onlineshoppractice.model.Product;
import com.onlineshoppractice.onlineshoppractice.model.ProductType;
import com.onlineshoppractice.onlineshoppractice.model.type.ProductTypePattern;
import com.onlineshoppractice.onlineshoppractice.repository.ProductRepository;
import com.onlineshoppractice.onlineshoppractice.repository.ProductTypeRepository;
import com.onlineshoppractice.onlineshoppractice.service.serviceinterface.ProductTypeServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductTypeService implements ProductTypeServiceInterface {

    private final ProductTypeRepository productTypeRepository;
    private final ProductRepository productRepository;

    public void createProductType(ProductType newProductType) {
        productTypeRepository.save(newProductType);
    }

    public List<ProductTypeDTO> getAllProductTypeDTO() {
        return productTypeRepository.findAll()
                .stream()
                .map(this::convertToProductTypeDTO)
                .collect(Collectors.toList());
    }

    //Remove Product Type and modify Product Type for existing Products to Default.
    public void removeProductType(Long productTypeId) {
        Optional<ProductType> removeProductType = findProductTypeById(productTypeId);
        if (removeProductType.isPresent()) {
            productTypeRepository.delete(removeProductType.get());
            List<Product> productsWithTheFindProductType = productRepository.findAll().stream()
                    .filter(product -> product.getProductType().equals(removeProductType.get()))
                    .toList();
            Optional<ProductType> defaultProductType = productTypeRepository.findByProductTypePattern(ProductTypePattern.OTHER);
            if (!productsWithTheFindProductType.isEmpty() && defaultProductType.isPresent()) {
                for (Product product: productsWithTheFindProductType) {
                    product.setProductType(defaultProductType.get());
                    productRepository.save(product);
                }
            }
        }
    }

    public void updateProductType(Long productTypeId, ProductType updateProductType) {
        Optional<ProductType> findProductType = findProductTypeById(productTypeId);
        if (findProductType.isPresent() && updateProductType != null) {
            com.onlineshoppractice.onlineshoppractice.model.ProductType productType = findProductType.get();
            productType.setProductTypePattern(updateProductType.getProductTypePattern());
            productTypeRepository.save(productType);
        }
    }


    private ProductTypeDTO convertToProductTypeDTO(ProductType productType) {
        ProductTypeDTO newProductTypeDTO = new ProductTypeDTO();

        newProductTypeDTO.setProductTypePattern(productType.getProductTypePattern());

        return newProductTypeDTO;
    }

    public Optional<ProductType> findProductTypeById(Long productTypeId) {
        return productTypeRepository.findById(productTypeId);
    }

}
