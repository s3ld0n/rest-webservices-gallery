package com.artisan.solutions.gallery.persistence.repository;

import com.artisan.solutions.gallery.persistence.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
