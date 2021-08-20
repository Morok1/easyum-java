package com.multiplication.multiplicationservicesmagin.repository;

import com.multiplication.multiplicationservicesmagin.model.Multiplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultiplicationRepository extends JpaRepository<Multiplication, Long> {
}
