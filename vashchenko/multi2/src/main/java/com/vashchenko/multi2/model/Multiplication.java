package com.vashchenko.multi2.model;

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
    @Column(name = "MULTIPLICATION_ID")
    private Long id;
    private final int factorA;
    private final int factorB;

    public Multiplication() {
        this(0, 0);
    }
}
