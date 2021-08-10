package com.easyum.hibernate;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class StandardSQLEntity {
    @Id
    @GeneratedValue
    Long id;
    @Column
    String field1, field2, field3, field4, field5, field6, field7, field8;

}
