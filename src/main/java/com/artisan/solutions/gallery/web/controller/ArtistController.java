package com.artisan.solutions.gallery.web.controller;

import com.artisan.solutions.gallery.configuration.Constants;
import com.artisan.solutions.gallery.service.ArtistService;
import com.artisan.solutions.gallery.web.dto.ArtistDto;
import com.artisan.solutions.gallery.web.dto.DtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    private ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArtistDto create(@RequestBody ArtistDto artistDto) {
        return DtoConverter.convertArtistToDto(artistService.create(DtoConverter.convertArtistDtoToEntity(artistDto)));
    }

    @GetMapping(Constants.ID)
    public ArtistDto findById(@PathVariable long id) {
        return DtoConverter.convertArtistToDto(artistService
                                                       .findById(id)
                                                       .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @GetMapping
    public List<ArtistDto> findAll() {
        return DtoConverter.convertAllArtistToDtos(artistService.findAll());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ArtistDto update(@RequestBody ArtistDto artistDto) {
        return DtoConverter.convertArtistToDto(artistService.update(DtoConverter.convertArtistDtoToEntity(artistDto)));
    }

    @DeleteMapping(Constants.ID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        artistService.deleteById(id);
    }
}
