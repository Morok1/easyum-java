package com.multic.multi.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@Getter
@Entity
public class MultiplicationAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private final MultUser user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private final Multiplication multiplication;

    private final int resultAttempt;
    private final int correct;


    public MultiplicationAttempt() {
        this(null, null, -1, false);
    }
}
