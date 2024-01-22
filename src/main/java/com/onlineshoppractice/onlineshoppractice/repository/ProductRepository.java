package com.onlineshoppractice.onlineshoppractice.repository;

import com.onlineshoppractice.onlineshoppractice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByProductName(String productName);
}
