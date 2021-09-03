package com.multic.multi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@Entity
public class MultUser {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private final String alias;

    public MultUser() {
        this(null);
    }
}
