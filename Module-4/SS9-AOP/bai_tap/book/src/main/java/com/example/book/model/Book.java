package com.example.book.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String name;
    private int quantity;
    private String author;
    private String price;
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "code_book_id",referencedColumnName = "inventoryId")
    private InventoryBook inventoryBook;


    public Book() {
    }

    public Book(int bookId, String name, int quantity, String author, String price, String description, InventoryBook inventoryBook) {
        this.bookId = bookId;
        this.name = name;
        this.quantity = quantity;
        this.author = author;
        this.price = price;
        this.description = description;
        this.inventoryBook = inventoryBook;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InventoryBook getInventoryBook() {
        return inventoryBook;
    }

    public void setInventoryBook(InventoryBook inventoryBook) {
        this.inventoryBook = inventoryBook;
    }
}
