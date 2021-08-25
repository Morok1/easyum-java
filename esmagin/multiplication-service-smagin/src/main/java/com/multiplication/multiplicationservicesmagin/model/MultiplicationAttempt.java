package com.multiplication.multiplicationservicesmagin.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MultiplicationAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private LocalDateTime localDateTime;


}
