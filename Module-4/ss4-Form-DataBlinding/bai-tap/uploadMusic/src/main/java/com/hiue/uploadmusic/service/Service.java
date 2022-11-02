package com.hiue.uploadmusic.service;

import com.hiue.uploadmusic.model.Music;
import org.springframework.stereotype.Controller;

import java.util.List;

public interface Service {
    List<Music> findAll();
    void save(Music music);

}
