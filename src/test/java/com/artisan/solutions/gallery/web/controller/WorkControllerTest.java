package com.artisan.solutions.gallery.web.controller;

import com.artisan.solutions.gallery.persistence.model.Work;
import com.artisan.solutions.gallery.service.impl.WorkServiceImpl;
import com.artisan.solutions.gallery.web.dto.WorkDto;
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
class WorkControllerTest {

    @InjectMocks
    private WorkController instance;

    @Mock
    private WorkServiceImpl artistService;

    @Mock
    private DtoConverter dtoConverter;

    @Mock
    private Work work;

    @Mock
    private WorkDto workDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        when(dtoConverter.convertWorkToDto(work)).thenReturn(workDto);
        when(dtoConverter.convertWorkDtoToEntity(workDto)).thenReturn(work);
    }

    @Test
    void create_runs_service_create() {
        when(artistService.create(work)).thenReturn(work);
        instance.create(workDto);
        verify(artistService, times(1)).create(work);
    }

    @Test
    void findById_runs_service_findById() {
        when(artistService.findById(1L)).thenReturn(Optional.of(work));

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
        when(artistService.update(work)).thenReturn(work);
        instance.update(workDto);
        verify(artistService, times(1)).update(work);
    }

    @Test
    void deleteById_runs_service_deleteById() {
        instance.deleteById(1L);
        verify(artistService, times(1)).deleteById(1L);
    }
}