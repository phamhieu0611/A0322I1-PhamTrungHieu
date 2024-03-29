package com.hiue.uploadmusic.model;

public class Music {
    private String nameSong;
    private String singer;
    private String type;
    private String link;

    public Music() {
    }

    public Music(String nameSong, String singer, String type, String link) {
        this.nameSong = nameSong;
        this.singer = singer;
        this.type = type;
        this.link = link;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Music{" +
                "nameSong='" + nameSong + '\'' +
                ", singer='" + singer + '\'' +
                ", type='" + type + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
