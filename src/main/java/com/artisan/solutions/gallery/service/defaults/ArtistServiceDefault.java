package com.artisan.solutions.gallery.service.defaults;

import com.artisan.solutions.gallery.persistence.model.Artist;
import com.artisan.solutions.gallery.persistence.repo.ArtistRepo;
import com.artisan.solutions.gallery.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceDefault implements ArtistService {

    private ArtistRepo artistRepo;

    @Autowired
    public ArtistServiceDefault(ArtistRepo artistRepo) {
        this.artistRepo = artistRepo;
    }

    @Override
    public Artist create(Artist artist) {
        return artistRepo.save(artist);
    }

    @Override
    public Optional<Artist> findById(Long id) {
        return artistRepo.findById(id);
    }

    @Override
    public List<Artist> findAll() {
        return artistRepo.findAll();
    }

    @Override
    public Artist update(Artist artist) {
        return create(artist);
    }

    @Override
    public void deleteById(Long id) {
        artistRepo.deleteById(id);
    }
}
