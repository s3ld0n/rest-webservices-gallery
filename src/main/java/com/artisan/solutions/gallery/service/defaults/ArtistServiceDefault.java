package com.artisan.solutions.gallery.service.defaults;

import com.artisan.solutions.gallery.persistence.model.Artist;
import com.artisan.solutions.gallery.persistence.repo.ArtistRepo;
import com.artisan.solutions.gallery.service.Crud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceDefault implements Crud<Artist> {

    private ArtistRepo artistRepo;

    @Autowired
    public ArtistServiceDefault(ArtistRepo artistRepo) {
        this.artistRepo = artistRepo;
    }

    public Artist create(Artist artist) {
        return artistRepo.save(artist);
    }

    public Optional<Artist> findById(Long id) {
        return artistRepo.findById(id);
    }

    public List<Artist> findAll() {
        return artistRepo.findAll();
    }

    public Artist update(Artist artist) {
        return create(artist);
    }

    public void delete(Artist artist) {
        artistRepo.delete(artist);
    }
}
