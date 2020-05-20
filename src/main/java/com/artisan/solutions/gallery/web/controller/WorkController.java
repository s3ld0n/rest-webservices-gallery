package com.artisan.solutions.gallery.web.controller;

import com.artisan.solutions.gallery.configuration.Constants;
import com.artisan.solutions.gallery.service.WorkService;
import com.artisan.solutions.gallery.web.dto.DtoConverter;
import com.artisan.solutions.gallery.web.dto.WorkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/works")
public class WorkController {

    private WorkService workService;
    private DtoConverter dtoConverter;

    @Autowired
    public WorkController(WorkService workService, DtoConverter dtoConverter) {
        this.workService = workService;
        this.dtoConverter = dtoConverter;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkDto create(@RequestBody WorkDto workDto) {
        return dtoConverter.convertWorkToDto(workService.create(dtoConverter.convertWorkDtoToEntity(workDto)));
    }

    @GetMapping(Constants.ID)
    public WorkDto findById(@PathVariable long id) {
        return dtoConverter.convertWorkToDto(workService
                                                     .findById(id)
                                                     .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @GetMapping
    public List<WorkDto> findAll() {
        return dtoConverter.convertAllWorksToDtos(workService.findAll());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public WorkDto update(@RequestBody WorkDto workDto) {
        return dtoConverter.convertWorkToDto(workService.update(dtoConverter.convertWorkDtoToEntity(workDto)));
    }

    @DeleteMapping(Constants.ID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        workService.deleteById(id);
    }

}
