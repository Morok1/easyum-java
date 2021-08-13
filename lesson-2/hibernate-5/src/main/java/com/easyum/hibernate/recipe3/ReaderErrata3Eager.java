package com.easyum.hibernate.recipe3;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class ReaderErrata3Eager {
    @Id
    @GeneratedValue()
    Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    Book3 book;
    @Temporal(TemporalType.TIMESTAMP)
    Date submitted;
    @Column(nullable = false)
    String content;
}
