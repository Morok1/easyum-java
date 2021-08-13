package com.easyum.hibernate.recipe5;

import lombok.Data;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@TypeDef(name="Geolocation", typeClass=GeolocationType.class)
public class Address {
    @Id
    @GeneratedValue
    Long id;
    @Column
    String streetAddress;
    @Type(type="com.easyum.hibernate.recipe5.GeolocationType")
    @Columns(columns={@Column(name="latitude"),@Column(name="longitude")})
    Geolocation geolocation;
}
