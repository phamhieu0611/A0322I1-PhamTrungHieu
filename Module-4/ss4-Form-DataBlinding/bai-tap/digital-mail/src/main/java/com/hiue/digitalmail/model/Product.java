package com.hiue.digitalmail.model;

import java.util.Arrays;

public class Product {
    private int id;
    private int filter;
    private int pageSize;
    private String languages;
    private String signature;

    public Product() {
    }

    public Product(int id, int filter, int pageSize, String languages, String signature) {
        this.id = id;
        this.filter = filter;
        this.pageSize = pageSize;
        this.languages = languages;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilter() {
        return filter;
    }

    public void setFilter(int filter) {
        this.filter = filter;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", filter=" + filter +
                ", pageSize=" + pageSize +
                ", languages='" + languages + '\'' +
                ", signature='" + signature + '\'' +
                '}';
    }
}
