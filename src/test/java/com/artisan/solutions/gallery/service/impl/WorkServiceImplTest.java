package com.artisan.solutions.gallery.service.impl;

import com.artisan.solutions.gallery.persistence.model.Work;
import com.artisan.solutions.gallery.persistence.repo.WorkRepo;
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
public class WorkServiceImplTest {

    @InjectMocks
    private WorkServiceImpl instance;

    @Mock
    private Work work1;

    @Mock
    private Work work2;

    @Mock
    private Work work3;

    @Mock
    private WorkRepo repo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void create_returnsCreatedObject_and_InvokesRepoSave() {
        when(repo.save(work1)).thenReturn(work1);
        assertEquals(work1, instance.create(work1));
        verify(repo, times(1)).save(work1);
    }

    @Test
    void findById_returnsOptionalWithRequiredObject_and_invokesRepoFindById() {
        Long id = 1L;
        when(repo.findById(id)).thenReturn(Optional.of(work1));

        assertThat(instance.findById(id).get()).isEqualTo(work1);
        verify(repo, times(1)).findById(id);
    }

    @Test
    void findAll_invokesRepoFindAll_and_returnsListOfArtistsOfCorrectSize() {
        List<Work> works = Arrays.asList(work1, work2, work3);
        when(repo.findAll()).thenReturn(works);

        assertThat(instance.findAll().size()).isEqualTo(3);
        verify(repo, times(1)).findAll();
    }

    @Test
    void update_invokesRepoSave() {
        when(repo.save(work1)).thenReturn(work1);
        instance.update(work1);
        verify(repo, times(1)).save(work1);
    }

    @Test
    void deleteById_invokesRepoDeleteById() {
        instance.deleteById(1L);
        verify(repo, times(1)).deleteById(1L);
    }
}
