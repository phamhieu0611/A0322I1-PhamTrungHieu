package com.example.music.service;

import com.example.music.model.Music;

import java.util.List;

public interface IService {

    List<Music> findAll();
    void save(Music music);
    Music findById(int id);
    void update(Music music);
    void delete(Music music);
}
