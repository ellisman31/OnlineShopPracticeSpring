package com.onlineshoppractice.onlineshoppractice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "online_shop_user_address")
public class Address {

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "city", nullable = false, length = 255)
    private String city;

    @Column(name = "postal_code", nullable = false)
    @Size(min = 1, max = 10)
    private int postalCode;

    @Column(name = "street_name", nullable = false, length = 255)
    private String streetName;

    @Column(name = "street_number", nullable = false, length = 255)
    private String streetNumber;

    @Column(name = "apartment_number", length = 255)
    private String apartmentNumber;

    @OneToMany(mappedBy = "address")
    @JsonBackReference
    private List<User> listOfUser;

    public Address(String city, int postalCode, String streetName, String streetNumber, String apartmentNumber) {
        this.city = city;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
    }
}
