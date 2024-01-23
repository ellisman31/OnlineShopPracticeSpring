package com.onlineshoppractice.onlineshoppractice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.onlineshoppractice.onlineshoppractice.model.type.ProductTypePattern;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "online_shop_product_type")
public class ProductType {

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "product_type")
    @Enumerated(EnumType.STRING)
    private ProductTypePattern productTypePattern;

    @OneToOne(mappedBy = "productType")
    @JsonBackReference
    private Product product;
}
