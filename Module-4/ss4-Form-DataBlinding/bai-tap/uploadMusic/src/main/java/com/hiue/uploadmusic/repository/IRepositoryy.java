package com.hiue.uploadmusic.repository;

import com.hiue.uploadmusic.model.Music;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class IRepositoryy implements Repositoryy {

    private static List<Music> musics;
    static {
        musics = new ArrayList<>();
        musics.add(new Music("Sao Nỡ Quên Đi","Danh Vũ Linh","Nhạc trẻ","https://www.nhaccuatui.com/bai-hat/sao-no-quen-di-danh-vu-linh.X0pO9OI0zTXY.html"));
        musics.add(new Music("Người Kế Nhiệm","Anh Khoa","Nhạc trẻ","https://www.nhaccuatui.com/bai-hat/nguoi-ke-nhiem-anh-khoa-tre.xSojugtvdTuN.html"));
        musics.add(new Music("Có Một Người ","Kha Nhỉ","Nhạc trẻ","https://www.nhaccuatui.com/bai-hat/co-mot-nguoi-kha-nhi.OHSK4uQ2k2zA.html"));
    }

    @Override
    public List<Music> findAll() {
        return musics;
    }

    @Override
    public void save(Music music) {
        musics.add(music);
    }
}
