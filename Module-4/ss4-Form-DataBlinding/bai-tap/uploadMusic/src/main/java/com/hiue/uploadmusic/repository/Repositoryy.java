package com.hiue.uploadmusic.repository;

import com.hiue.uploadmusic.model.Music;

import java.util.List;

public interface Repositoryy {
    List<Music> findAll();

    void save(Music music);
}
