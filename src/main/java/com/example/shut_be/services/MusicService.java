package com.example.shut_be.services;

import com.example.shut_be.domains.Music;
import com.example.shut_be.repositories.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MusicService {
    @Autowired
    private MusicRepository musicRepository;

    public List<Music> listAllMusic() {
        return musicRepository.findAll();
    }

    public Music saveMusic(Music music) {
        return musicRepository.save(music);
    }

    public Music getMusic(Integer id) {
        return musicRepository.findById(id).get();
    }

    public void deleteMusic(Integer id) {
        musicRepository.deleteById(id);
    }
}