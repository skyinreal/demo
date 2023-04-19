package com.example.demo.repository;

import com.example.demo.model.Act;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActRepository extends JpaRepository<Act, Integer> {
    Act findByNumber(String number);
    Optional<Act> findById(Integer id);

}
