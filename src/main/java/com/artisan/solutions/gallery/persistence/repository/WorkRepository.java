package com.artisan.solutions.gallery.persistence.repository;

import com.artisan.solutions.gallery.persistence.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {

}
