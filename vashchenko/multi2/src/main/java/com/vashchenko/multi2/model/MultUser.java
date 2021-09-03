package com.vashchenko.multi2.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class MultUser {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    private final String alias;

    protected MultUser() {
        alias = null;

    }
}

