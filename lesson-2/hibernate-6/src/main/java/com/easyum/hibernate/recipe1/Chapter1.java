package com.easyum.hibernate.recipe1;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@EqualsAndHashCode(exclude = "book")
@ToString(exclude = "book")
public class Chapter1 {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Getter
    @Setter
    String title;
    @Getter
    @Setter
    String content;
    @ManyToOne(optional = false)
    @Getter
    @Setter
    Book1 book;
}
