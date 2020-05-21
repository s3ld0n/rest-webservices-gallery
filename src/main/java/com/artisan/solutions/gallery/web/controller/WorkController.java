package com.artisan.solutions.gallery.web.controller;

import com.artisan.solutions.gallery.service.WorkService;
import com.artisan.solutions.gallery.web.dto.DtoConverter;
import com.artisan.solutions.gallery.web.dto.WorkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public WorkDto create(@RequestBody WorkDto workDto) {
        return dtoConverter.convertWorkToDto(workService.create(dtoConverter.convertWorkDtoToEntity(workDto)));
    }

    @GetMapping(Constants.ID)
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public WorkDto findById(@PathVariable long id) {
        return dtoConverter.convertWorkToDto(workService.findById(id)
                                                     .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public List<WorkDto> findAll() {
        return dtoConverter.convertAllWorksToDtos(workService.findAll());
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public WorkDto update(@RequestBody WorkDto workDto) {
        return dtoConverter.convertWorkToDto(workService.update(dtoConverter.convertWorkDtoToEntity(workDto)));
    }

    @DeleteMapping(Constants.ID)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        workService.deleteById(id);
    }

}
