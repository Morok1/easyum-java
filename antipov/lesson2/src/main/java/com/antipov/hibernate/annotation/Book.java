package com.antipov.hibernate.annotation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Book {
    @Id

    @Column
    private final String name_book;

    public Book(String name, String publishingHouse, String name_book) {
        super(name, publishingHouse);
        this.name_book = name_book;
    }
}
