package com.example.shut_be.services;

import com.example.shut_be.domains.Pic;
import com.example.shut_be.repositories.PicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PicService {
    @Autowired
    private PicRepository picRepository;

    public List<Pic> listAllPic() {
        return picRepository.findAll();
    }

    public Pic savePic(Pic pic) {
        return picRepository.save(pic);
    }

    public Pic getPic(Integer id) {
        return picRepository.findById(id).get();
    }

    public void deletePic(Integer id) {
        picRepository.deleteById(id);
    }
}