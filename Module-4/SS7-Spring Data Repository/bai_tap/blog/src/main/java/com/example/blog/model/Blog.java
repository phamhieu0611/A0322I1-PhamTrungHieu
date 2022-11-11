package com.example.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String author;
private String description;

    public Blog() {
    }

    public Blog(int id, String author, String description) {
        this.id = id;
        this.author = author;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
