package com.vashchenko.multi2.repository;

import com.vashchenko.multi2.model.Multiplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultiplicationRepository extends JpaRepository<Multiplication, Long> {
}
