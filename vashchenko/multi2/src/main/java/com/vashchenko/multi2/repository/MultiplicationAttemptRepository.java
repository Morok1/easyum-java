package com.vashchenko.multi2.repository;


import com.vashchenko.multi2.model.MultiplicationAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MultiplicationAttemptRepository extends JpaRepository<MultiplicationAttempt, Long> {
    List<MultiplicationAttempt> findTop5ByUserAliasOrderByIdDesc(String alias);
}