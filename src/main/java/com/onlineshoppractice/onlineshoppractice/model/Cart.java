package com.onlineshoppractice.onlineshoppractice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "online_shop_cart")
public class Cart {
    @Id @GeneratedValue
    @Column(name = "id")
    private long id;

    @OneToOne(mappedBy = "cart")
    private User user;

    @OneToMany(mappedBy = "cart")
    private List<Product> listOfProduct;

    public Cart(User user, List<Product> listOfProduct) {
        this.user = user;
        this.listOfProduct = listOfProduct;
    }
}
