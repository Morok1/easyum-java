package com.easyum.hibernate.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class EmbeddedContact {
    @Column
    String name;
    @Column
    String address;
    @Column
    String phone;
}
