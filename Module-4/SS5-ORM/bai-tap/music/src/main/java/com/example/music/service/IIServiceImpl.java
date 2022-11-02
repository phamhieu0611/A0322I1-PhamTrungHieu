package com.example.music.service;

import com.example.music.model.Music;
import com.example.music.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IIServiceImpl implements IService {

    @Autowired
    private IRepository iRepository;

    @Override
    public List<Music> findAll() {
        return iRepository.findAll();
    }

    @Override
    public void save(Music music) {
        iRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return iRepository.findById(id);
    }

    @Override
    public void update(Music music) {
        iRepository.update(music);
    }

    @Override
    public void delete(Music music) {
        iRepository.delete(music);
    }
}
