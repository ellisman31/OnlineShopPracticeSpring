package com.onlineshoppractice.onlineshoppractice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "online_shop_product")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productTypeId", referencedColumnName = "id")
    private ProductType productType;

    @Column(name = "product_description")
    private String productDescription;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "onlineShopCartId", referencedColumnName = "id")
    private Cart cart;

    public Product(String productName, BigDecimal productPrice, ProductType productType, String productDescription) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productType = productType;
        this.productDescription = productDescription;
    }
}
