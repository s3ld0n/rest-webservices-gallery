package com.artisan.solutions.gallery.service.impl;

import com.artisan.solutions.gallery.persistence.model.Work;
import com.artisan.solutions.gallery.persistence.repo.WorkRepo;
import com.artisan.solutions.gallery.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkServiceImpl implements WorkService {

    private WorkRepo workRepo;

    @Autowired
    public WorkServiceImpl(WorkRepo workRepo) {
        this.workRepo = workRepo;
    }

    @Override
    public Work create(Work work) {
        return workRepo.save(work);
    }

    @Override
    public Optional<Work> findById(Long id) {
        return workRepo.findById(id);
    }

    @Override
    public List<Work> findAll() {
        return workRepo.findAll();
    }

    @Override
    public Work update(Work work) {
        return workRepo.save(work);
    }

    @Override
    public void deleteById(Long id) {
        workRepo.deleteById(id);
    }
}
