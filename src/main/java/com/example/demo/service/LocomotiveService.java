package com.example.demo.service;

import com.example.demo.model.Act;
import com.example.demo.model.Locomotive;

import java.util.List;

public interface LocomotiveService {
    List<Locomotive> getActs();
    Locomotive save(Locomotive locomotive);
}
