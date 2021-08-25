package com.vashchenko.multi2.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
//        (schema="MULTIPLICATION_OWNER")
public class MultiplicationAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private LocalDateTime localDateTime;


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinTable(name = "MULTIPLICATION_ATTEMPT_MULTIPLICATION",
//            joinColumns = @JoinColumn(name = "multiplication_attempt.id"),
//            inverseJoinColumns = @JoinColumn(name = "multiplication.id"))
//    private Multiplication multiplication;


}
