package com.example.demo.service;

import com.example.demo.model.Act;
import com.example.demo.model.Locomotive;
import com.example.demo.repository.LocomotiveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocomotiveServiceImpl implements LocomotiveService{
    private final LocomotiveRepository locomotiveRepository;

    public LocomotiveServiceImpl(LocomotiveRepository locomotiveRepository) {
        this.locomotiveRepository = locomotiveRepository;
    }

    @Override
    public List<Locomotive> getActs() {
        return null;
    }

    @Override
    public Locomotive save(Locomotive locomotive) {
        return locomotiveRepository.save(locomotive);
    }
}
