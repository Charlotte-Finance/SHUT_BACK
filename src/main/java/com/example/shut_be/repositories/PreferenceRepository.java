package com.example.shut_be.repositories;


import com.example.shut_be.domains.Preference;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PreferenceRepository extends JpaRepository<Preference, Integer> {
}