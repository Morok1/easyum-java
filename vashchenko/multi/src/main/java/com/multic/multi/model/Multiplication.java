package com.multic.multi.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Getter
@Entity
public class Multiplication {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private final int factorA;
    @Column
    private final int factorB;

    public Multiplication() {
        this(0, 0);
    }
}
