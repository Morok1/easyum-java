package com.easyum.hibernate.recipe3;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class AudioDisc3 extends Disc3 {
    @Column
    int trackCount;
    @Column
    String artist;
}
