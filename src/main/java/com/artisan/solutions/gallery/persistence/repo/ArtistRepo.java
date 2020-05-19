package com.artisan.solutions.gallery.persistence.repo;

import com.artisan.solutions.gallery.persistence.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepo extends JpaRepository<Artist, Long> {

}
