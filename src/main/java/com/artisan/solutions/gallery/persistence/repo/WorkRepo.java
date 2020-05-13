package com.artisan.solutions.gallery.persistence.repo;

import com.artisan.solutions.gallery.persistence.model.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepo extends JpaRepository<Work, Long> {

}
