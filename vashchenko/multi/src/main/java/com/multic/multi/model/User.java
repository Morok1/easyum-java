package com.multic.multi.model;

import javax.persistence.*;

@Entity
@Table(name="\"user\"")
//        (schema="USER_OWNER")
public class User {
    @Id
    @GeneratedValue()
    private Long id;
    @Column
    private String name;

}

