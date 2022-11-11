package com.example.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int newId;
    private Long categoryId;
    private String categoryName;

    public Category() {
    }

    public Category(int newId, Long categoryId, String categoryName) {
        this.newId = newId;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getNewId() {
        return newId;
    }

    public void setNewId(int newId) {
        this.newId = newId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "newId=" + newId +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
