package com.artisan.solutions.gallery.service.impl;

import com.artisan.solutions.gallery.persistence.model.Artist;
import com.artisan.solutions.gallery.persistence.repository.ArtistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class ArtistServiceImplTest {

    @InjectMocks
    private ArtistServiceImpl instance;

    @Mock
    private ArtistRepository repo;

    @Mock
    private Artist artist1;

    @Mock
    private Artist artist2;

    @Mock
    private Artist artist3;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void create_returnsCreatedObject_and_InvokesRepoSave() {
        when(repo.save(artist1)).thenReturn(artist1);
        assertEquals(artist1, instance.create(artist1));
        verify(repo, times(1)).save(artist1);
    }

    @Test
    void findById_returnsOptionalWithRequiredObject_and_invokesRepoFindById() {
        Long id = 1L;
        when(repo.findById(id)).thenReturn(Optional.of(artist1));

        assertThat(instance.findById(id).get()).isEqualTo(artist1);
        verify(repo, times(1)).findById(id);
    }

    @Test
    void findAll_invokesRepoFindAll_and_returnsListOfArtistsOfCorrectSize() {
        List<Artist> artists = Arrays.asList(artist1, artist2, artist3);
        when(repo.findAll()).thenReturn(artists);

        assertThat(instance.findAll().size()).isEqualTo(3);
        verify(repo, times(1)).findAll();
    }

    @Test
    void update_invokesRepoSave() {
        when(repo.save(artist1)).thenReturn(artist1);
        instance.update(artist1);
        verify(repo, times(1)).save(artist1);
    }

    @Test
    void deleteById_invokesRepoDeleteById() {
        instance.deleteById(1L);
        verify(repo, times(1)).deleteById(1L);
    }
}