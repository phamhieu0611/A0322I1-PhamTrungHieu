package com.example.music.repository;

import com.example.music.model.Music;

import java.util.List;

public interface IRepository {

    List<Music> findAll();
    void save(Music music);
    Music findById(int id);
    void update(Music music);
    void delete(Music music);
}
