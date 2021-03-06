package com.easyum.hibernate.recipe1;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class AudioDisc extends Disc {
    @Column
    int trackCount;
    @Column
    String artist;
}
