package com.multiplication.multiplicationservicesmagin.model;

import lombok.*;

import javax.persistence.*;
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class Multiplication {
    @Id
    @GeneratedValue
    @Column(name="MULTIPLICATION_ID")
    private long id;
    private final int factorA;
    private final int factorB;

    Multiplication(){
        this(0, 0);
    }


}
