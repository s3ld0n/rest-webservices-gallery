package com.artisan.solutions.gallery.web.controller;

import com.artisan.solutions.gallery.persistence.model.Artist;
import com.artisan.solutions.gallery.service.impl.ArtistServiceImpl;
import com.artisan.solutions.gallery.web.dto.ArtistDto;
import com.artisan.solutions.gallery.web.dto.DtoConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class ArtistControllerTest {

    @InjectMocks
    private ArtistController instance;

    @Mock
    private ArtistServiceImpl artistService;

    @Mock
    private DtoConverter dtoConverter;

    @Mock
    private Artist artist;

    @Mock
    private ArtistDto artistDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        when(dtoConverter.convertArtistToDto(artist)).thenReturn(artistDto);
        when(dtoConverter.convertArtistDtoToEntity(artistDto)).thenReturn(artist);
    }

    @Test
    void create_runs_service_create() {
        when(artistService.create(artist)).thenReturn(artist);
        instance.create(artistDto);
        verify(artistService, times(1)).create(artist);
    }

    @Test
    void findById_runs_service_findById() {
        when(artistService.findById(1L)).thenReturn(Optional.of(artist));

        instance.findById(1L);
        verify(artistService, times(1)).findById(1L);
    }

    @Test
    void findAll_runs_service_findAll() {
        when(artistService.findAll()).thenReturn(Collections.EMPTY_LIST);

        instance.findAll();
        verify(artistService, times(1)).findAll();
    }

    @Test
    void update_runs_service_update() {
        when(artistService.update(artist)).thenReturn(artist);
        instance.update(artistDto);
        verify(artistService, times(1)).update(artist);
    }

    @Test
    void deleteById_runs_service_deleteById() {
        instance.deleteById(1L);
        verify(artistService, times(1)).deleteById(1L);
    }
}