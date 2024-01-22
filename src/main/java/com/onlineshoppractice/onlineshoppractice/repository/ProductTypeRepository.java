package com.onlineshoppractice.onlineshoppractice.repository;

import com.onlineshoppractice.onlineshoppractice.model.ProductType;
import com.onlineshoppractice.onlineshoppractice.model.type.ProductTypePattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductTypeRepository extends JpaRepository<com.onlineshoppractice.onlineshoppractice.model.ProductType, Long> {

    Optional<ProductType> findByProductTypePattern(ProductTypePattern productTypePattern);

}
