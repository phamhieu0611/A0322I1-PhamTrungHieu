package com.example.restful.Service;

import java.util.Optional;

public interface IGenericService <T>{
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    void remove(Long t);
}
