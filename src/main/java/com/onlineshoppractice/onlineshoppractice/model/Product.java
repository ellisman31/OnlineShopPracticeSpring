package com.onlineshoppractice.onlineshoppractice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "online_shop_product")
public class Product {

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "product_name", nullable = false, length = 255)
    private String productName;

    @Column(name = "product_price", nullable = false, precision = 100, scale = 2)
    private BigDecimal productPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productTypeId", referencedColumnName = "id", nullable = false)
    @JsonManagedReference
    private ProductType productType;

    @Column(name = "product_description", length = 255)
    private String productDescription;

    @Column(name = "product_amount", nullable = false)
    private int productAmount;

    @Column(name = "product_availability")
    private Boolean productAvailability;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "onlineShopCartId", referencedColumnName = "id")
    @JsonIgnore
    private Cart cart;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "onlineShopInventoryId", referencedColumnName = "id")
    @JsonIgnore
    private Inventory inventory;

    public Product(String productName, BigDecimal productPrice, ProductType productType, String productDescription, int productAmount) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productType = productType;
        this.productDescription = productDescription;
        this.productAmount = productAmount;
        this.productAvailability = checkProductAvailability();
    }

    private boolean checkProductAvailability() {
        return getProductAmount() > 0;
    }
}
