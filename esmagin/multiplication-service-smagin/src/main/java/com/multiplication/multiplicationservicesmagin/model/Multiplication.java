package com.multiplication.multiplicationservicesmagin.model;

import lombok.Data;

import javax.persistence.*;



@Entity
public class Multiplication {
    @Id
    @GeneratedValue
    @Column(name="MULTIPLICATION_ID")
    private long id;
    @Column
    private int factorA;
    @Column
    private int factorB;
    @Transient
    private int result;





}
