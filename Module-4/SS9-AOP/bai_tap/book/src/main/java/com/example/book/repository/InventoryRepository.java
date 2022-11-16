package com.example.book.repository;

import com.example.book.model.InventoryBook;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<InventoryBook, Integer> {
}
