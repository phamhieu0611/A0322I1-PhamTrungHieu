package com.hiue.uploadmusic.service;

import com.hiue.uploadmusic.model.Music;
import com.hiue.uploadmusic.repository.IRepositoryy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class IService implements Service{

    @Autowired
    private IRepositoryy iRepository;

    @Override
    public List<Music> findAll() {
        return iRepository.findAll();
    }

    @Override
    public void save(Music music) {
        iRepository.save(music);
    }
}
