package com.multivashchenko.multi.repository;

import com.multivashchenko.multi.model.Multiplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultiplicationRepository extends JpaRepository<Multiplication, String> {


}
