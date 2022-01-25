package com.example.shut_be.controllers;

import com.example.shut_be.domains.Pic;
import com.example.shut_be.services.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/pics")
public class PicsController {
    @Autowired
    PicService picService;

    @GetMapping("")
    public List<Pic> list() {
        return picService.listAllPic();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pic> get(@PathVariable Integer id) {
        try {
            Pic pic = picService.getPic(id);
            return new ResponseEntity<>(pic, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Pic> add(@RequestBody Pic pic) {
        try {
            return new ResponseEntity<>(picService.savePic(pic), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        picService.deletePic(id);
    }
}