package com.example.shut_be.controllers;

import com.example.shut_be.domains.Music;
import com.example.shut_be.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/musics")
public class MusicController {
    @Autowired
    MusicService musicService;

    @GetMapping("")
    public List<Music> list() {
        return musicService.listAllMusic();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Music> get(@PathVariable Integer id) {
        try {
            Music music = musicService.getMusic(id);
            return new ResponseEntity<>(music, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Music> add(@RequestBody Music music) {
        try {
            return new ResponseEntity<>(musicService.saveMusic(music), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        musicService.deleteMusic(id);
    }
}