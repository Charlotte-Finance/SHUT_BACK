package com.example.shut_be.controllers;

import com.example.shut_be.domains.Pic;
import com.example.shut_be.services.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@RestController
@RequestMapping("/values")
public class ValueController {
    @Autowired
    PicService picService;

    @GetMapping("")
    public Integer getValue() {
        return fetchValueFromObject();
    }

    public Integer fetchValueFromObject() {
        // ToDo : implement
        //"/preferences/$userId"
        Random rand = new Random();
        return rand.nextInt(71);
    }
}