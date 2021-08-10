package com.easyum.hibernate;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@DynamicInsert
public class DynamicSQLEntity {
    @Id
    @GeneratedValue
    Long id;
    @Column
    String field1, field2, field3, field4, field5, field6, field7, field8;

}

