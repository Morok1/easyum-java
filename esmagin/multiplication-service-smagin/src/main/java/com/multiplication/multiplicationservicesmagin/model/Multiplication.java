package com.multiplication.multiplicationservicesmagin.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "MULTIPLICATION_OWNER")
public class Multiplication {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column
    private int factorA;
    @Column
    private int factorB;
    @Transient
    private int result;


}
