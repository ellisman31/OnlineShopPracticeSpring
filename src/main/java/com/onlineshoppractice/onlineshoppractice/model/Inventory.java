package com.onlineshoppractice.onlineshoppractice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "online_shop_inventory")
public class Inventory {

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "inventory")
    @JsonBackReference
    private List<Product> onlineShopProducts;

}
