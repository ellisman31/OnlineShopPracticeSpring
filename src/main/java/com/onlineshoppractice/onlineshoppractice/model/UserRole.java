package com.onlineshoppractice.onlineshoppractice.model;

import com.onlineshoppractice.onlineshoppractice.model.type.UserRolePattern;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private User user;
}
