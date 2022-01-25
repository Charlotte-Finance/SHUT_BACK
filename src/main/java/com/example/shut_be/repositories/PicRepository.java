package com.example.shut_be.repositories;


import com.example.shut_be.domains.Pic;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PicRepository extends JpaRepository<Pic, Integer> {
}