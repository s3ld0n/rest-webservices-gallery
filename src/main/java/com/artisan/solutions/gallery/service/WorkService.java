package com.artisan.solutions.gallery.service;

import com.artisan.solutions.gallery.persistence.model.Work;

import java.util.List;
import java.util.Optional;

public interface WorkService extends Crud<Work> {
    Work create(Work work);

    Optional<Work> findById(Long id);

    List<Work> findAll();

    Work update(Work work);

    void delete(Work work);
}
