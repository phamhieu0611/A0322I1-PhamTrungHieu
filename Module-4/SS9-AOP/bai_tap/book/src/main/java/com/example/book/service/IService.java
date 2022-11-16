package com.example.book.service;

import com.example.book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService {
    Page<Book> findAll(Pageable pageable);
    void save(Book book);

}
