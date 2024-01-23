package com.onlineshoppractice.onlineshoppractice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "online_shop_cart")
public class Cart {

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "cart")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "cart")
    @JsonManagedReference
    private List<Product> listOfProduct;

    public Cart(User user, List<Product> listOfProduct) {
        this.user = user;
        this.listOfProduct = listOfProduct;
    }
}
