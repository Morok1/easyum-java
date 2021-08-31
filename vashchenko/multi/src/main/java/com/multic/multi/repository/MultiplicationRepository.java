package com.multic.multi.repository;

import com.multic.multi.model.Multiplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultiplicationRepository extends JpaRepository<Multiplication, String> {

}
