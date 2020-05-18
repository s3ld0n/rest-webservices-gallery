package com.artisan.solutions.gallery.service.impl;

import com.artisan.solutions.gallery.persistence.model.Work;
import com.artisan.solutions.gallery.persistence.repository.WorkRepository;
import com.artisan.solutions.gallery.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkServiceImpl implements WorkService {

    private WorkRepository workRepository;

    @Autowired
    public WorkServiceImpl(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    @Override
    public Work create(Work work) {
        return workRepository.save(work);
    }

    @Override
    public Optional<Work> findById(Long id) {
        return workRepository.findById(id);
    }

    @Override
    public List<Work> findAll() {
        return workRepository.findAll();
    }

    @Override
    public Work update(Work work) {
        return workRepository.save(work);
    }

    @Override
    public void deleteById(Long id) {
        workRepository.deleteById(id);
    }
}
