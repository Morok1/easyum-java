package com.antipov.hibernate.annotation;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private final String name;
    @Column
    private final String publishingHouse;
}
