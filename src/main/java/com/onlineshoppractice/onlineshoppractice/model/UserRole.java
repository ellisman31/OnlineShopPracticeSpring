package com.onlineshoppractice.onlineshoppractice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.onlineshoppractice.onlineshoppractice.model.type.UserRolePattern;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "online_shop_user_role_type")
public class UserRole {

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "online_shop_user_role")
    @Enumerated(EnumType.STRING)
    private UserRolePattern onlineShopUserRole;

    @OneToOne(mappedBy = "userRole")
    @JsonBackReference
    private User user;
}
