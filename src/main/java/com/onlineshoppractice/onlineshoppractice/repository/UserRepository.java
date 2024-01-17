package com.onlineshoppractice.onlineshoppractice.repository;

import com.onlineshoppractice.onlineshoppractice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
