package com.vashchenko.multi2.model;

import javax.persistence.*;

@Entity
@Table
//        (schema="USER_OWNER")
public class User {
    @Id
    @GeneratedValue()
    private Long id;
    @Column
    private String name;

}

