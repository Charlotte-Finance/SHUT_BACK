package com.example.shut_be.repositories;


import com.example.shut_be.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByEmail(String email);
}