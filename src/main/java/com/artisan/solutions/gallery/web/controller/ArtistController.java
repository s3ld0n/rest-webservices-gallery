package com.artisan.solutions.gallery.web.controller;

import com.artisan.solutions.gallery.configuration.Constants;
import com.artisan.solutions.gallery.service.ArtistService;
import com.artisan.solutions.gallery.web.dto.ArtistDto;
import com.artisan.solutions.gallery.web.dto.DtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    private ArtistService artistService;
    private DtoConverter dtoConverter;

    @Autowired
    public ArtistController(ArtistService artistService, DtoConverter dtoConverter) {
        this.artistService = artistService;
        this.dtoConverter = dtoConverter;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public ArtistDto create(@RequestBody ArtistDto artistDto) {
        return dtoConverter.convertArtistToDto(
                artistService.create(
                        dtoConverter.convertArtistDtoToEntity(artistDto)));
    }

    @GetMapping(Constants.ID)
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ArtistDto findById(@PathVariable long id) {
        return dtoConverter.convertArtistToDto(artistService
                                                       .findById(id)
                                                       .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public List<ArtistDto> findAll() {
        return dtoConverter.convertAllArtistToDtos(artistService.findAll());
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public ArtistDto update(@RequestBody ArtistDto artistDto) {
        return dtoConverter.convertArtistToDto(artistService.update(dtoConverter.convertArtistDtoToEntity(artistDto)));
    }

    @DeleteMapping(Constants.ID)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        artistService.deleteById(id);
    }
}
