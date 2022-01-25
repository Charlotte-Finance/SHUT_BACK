package com.example.shut_be.repositories;


import com.example.shut_be.domains.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;


public interface PreferenceRepository extends JpaRepository<Preference, Integer> {
    Preference findByUserId(int userId);
}