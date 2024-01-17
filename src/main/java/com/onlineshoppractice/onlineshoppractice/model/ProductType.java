package com.onlineshoppractice.onlineshoppractice.model;

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
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "product_type")
    private com.onlineshoppractice.onlineshoppractice.model.type.ProductType productType;

    @OneToOne(mappedBy = "productType")
    private Product product;
}
