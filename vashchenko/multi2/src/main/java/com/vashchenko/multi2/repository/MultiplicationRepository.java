package com.vashchenko.multi2.repository;


import com.vashchenko.multi2.model.Multiplication;
import com.vashchenko.multi2.model.MultiplicationAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MultiplicationRepository extends JpaRepository<MultiplicationAttempt, String> {
    @Override
    Optional<MultiplicationAttempt> findById(String s);

    @Override
    List<MultiplicationAttempt> findAll();
}
