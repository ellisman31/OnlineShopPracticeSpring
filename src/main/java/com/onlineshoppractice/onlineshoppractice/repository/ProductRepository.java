package com.onlineshoppractice.onlineshoppractice.repository;

import com.onlineshoppractice.onlineshoppractice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
