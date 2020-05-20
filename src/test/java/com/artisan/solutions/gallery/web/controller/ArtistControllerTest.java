package com.artisan.solutions.gallery.web.controller;


import com.artisan.solutions.gallery.persistence.model.Artist;
import com.artisan.solutions.gallery.persistence.repository.ArtistRepository;
import com.artisan.solutions.gallery.service.ArtistService;
import com.artisan.solutions.gallery.service.impl.ArtistServiceImpl;
import com.artisan.solutions.gallery.web.dto.ArtistDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
class ArtistControllerTest {

    @InjectMocks
    private ArtistController instance;

    @Mock
    private ArtistServiceImpl artistService;

    @Mock
    private Artist artist;

    @Mock
    private ArtistDto artistDto;

    @Mock
    private ArtistDto artist3;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        when(artistDto.getId()).thenReturn(1L);
        when(artistDto.getEmail()).thenReturn("1@1.c");
        when(artistDto.getFirstName()).thenReturn("John");
        when(artistDto.getLastName()).thenReturn("Doe");
        when(artistDto.getPassword()).thenReturn("123");
        when(artistDto.getWorks()).thenReturn(Collections.emptyList());

        when(artist.getId()).thenReturn(1L);
        when(artist.getEmail()).thenReturn("1@1.c");
        when(artist.getFirstName()).thenReturn("John");
        when(artist.getLastName()).thenReturn("Doe");
        when(artist.getPassword()).thenReturn("123");
        when(artist.getWorks()).thenReturn(Collections.emptyList());

        when(artistService.create(artist)).thenReturn(artist);
    }

    @Test
    void create() {
        instance.create(artistDto);
        verify(artistService, times(1)).create(artist);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }
}