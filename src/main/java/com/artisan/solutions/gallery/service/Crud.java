package com.artisan.solutions.gallery.service;

import java.util.List;
import java.util.Optional;

public interface Crud<T> {

    T create(T t);

    Optional<T> findById(Long id);

    List<T> findAll();

    T update(T t);

    void deleteById(Long id);
}
