package com.artisan.solutions.gallery.web.controller;

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

    @Autowired
    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorkDto create(@RequestBody WorkDto workDto) {
        return DtoConverter.convertWorkToDto(workService.create(DtoConverter.convertWorkDtoToEntity(workDto)));
    }

    @GetMapping("/{id}")
    public WorkDto findById(@PathVariable long id) {
        return DtoConverter.convertWorkToDto(workService
                                                     .findById(id)
                                                     .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @GetMapping
    public List<WorkDto> findAll() {
        return DtoConverter.convertAllWorksToDtos(workService.findAll());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public WorkDto update(@RequestBody WorkDto workDto) {
        return DtoConverter.convertWorkToDto(workService.update(DtoConverter.convertWorkDtoToEntity(workDto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        workService.deleteById(id);
    }

}
