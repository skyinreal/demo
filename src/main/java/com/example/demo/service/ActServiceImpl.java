package com.example.demo.service;

import com.example.demo.model.Act;
import com.example.demo.repository.ActRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActServiceImpl implements ActService{

    private final ActRepository actRepository;

    @Autowired
    public ActServiceImpl(ActRepository actRepository) {
        this.actRepository = actRepository;
    }

    @Override
    public List<Act> getActs() {
        return actRepository.findAll();
    }

    @Override
    public Act save(Act act){
        return actRepository.save(act);
    }

    @Override
    public Act getByNumber(String number) {
        return actRepository.findByNumber(number);
    }

    @Override
    public Act getById(Integer id) {
        return null;
    }

}
