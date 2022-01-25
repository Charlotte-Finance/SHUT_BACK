package com.example.shut_be.services;

import com.example.shut_be.domains.Preference;
import com.example.shut_be.repositories.PreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PreferenceService {
    @Autowired
    private PreferenceRepository preferenceRepository;

    public List<Preference> listAllPreference() {
        return preferenceRepository.findAll();
    }

    public Preference savePreference(Preference preference) {
        return preferenceRepository.save(preference);
    }

    public Preference getPreference(Integer id) {
        return preferenceRepository.findById(id).get();
    }

    public void deletePreference(Integer id) {
        preferenceRepository.deleteById(id);
    }
}