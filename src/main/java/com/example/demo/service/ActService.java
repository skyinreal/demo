package com.example.demo.service;

import com.example.demo.model.Act;

import java.util.List;

public interface ActService {
    List<Act> getActs();
    Act save(Act act);
    Act getByNumber(String number);
    Act getById(Integer id);

}
