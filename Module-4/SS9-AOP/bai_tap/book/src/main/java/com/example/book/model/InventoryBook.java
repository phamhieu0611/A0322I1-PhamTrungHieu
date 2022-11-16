package com.example.book.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
public class InventoryBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private int inventoryId;
    private String codeRent;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public InventoryBook() {
    }

    public InventoryBook(int inventoryId, String codeRent, Book book) {
        this.inventoryId = inventoryId;
        this.codeRent = codeRent;
        this.book = book;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getCodeRent() {
        return codeRent;
    }

    public void setCodeRent(String codeRent) {
        this.codeRent = codeRent;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
