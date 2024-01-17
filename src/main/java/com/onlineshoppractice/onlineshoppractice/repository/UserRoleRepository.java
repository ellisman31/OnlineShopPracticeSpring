package com.onlineshoppractice.onlineshoppractice.repository;

import com.onlineshoppractice.onlineshoppractice.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
