package com.example.music.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String singer;
    private String kind;
    private String url;

    public Music() {
    }

    public Music(int id, String name, String singer, String kind, String url) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.kind = kind;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String typeOf) {
        this.kind = typeOf;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String link) {
        this.url = link;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                ", typeOf='" + kind + '\'' +
                ", link='" + url + '\'' +
                '}';
    }
}
