package com.example.shut_be.controllers;

import com.example.shut_be.domains.Post;
import com.example.shut_be.domains.Preference;
import com.example.shut_be.services.PreferenceService;
import com.example.shut_be.services.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/preferences")
public class PreferenceController {
    @Autowired
    PreferenceService preferenceService;

    @GetMapping("")
    public List<Preference> list() {
        return preferenceService.listAllPreference();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Preference> get(@PathVariable Integer id) {
        try {
            Preference preference = preferenceService.getPreference(id);
            return new ResponseEntity<>(preference, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Preference> add(@RequestBody Preference preference) {
        try {
            return new ResponseEntity<>(preferenceService.savePreference(preference), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Preference> change(@RequestBody Preference preference) {
        try {
            Preference newPreference = preferenceService.savePreference(preference);
            onChangePreference(newPreference);
            return new ResponseEntity<>(newPreference, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        preferenceService.deletePreference(id);
    }

    @PostMapping("/update")
    public void onChangePreference(Preference preference){
        RestTemplateBuilder rest = new RestTemplateBuilder();
        RestService service = new RestService(rest);
        service.sendUpdate(preference);
    }
}

