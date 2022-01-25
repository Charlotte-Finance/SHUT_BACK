package com.example.shut_be.repositories;


import com.example.shut_be.domains.Music;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MusicRepository extends JpaRepository<Music, Integer> {
}