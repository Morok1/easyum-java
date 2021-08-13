package com.easyum.hibernate.recipe6;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Data
@NoArgsConstructor
public class Book6NaturalSorting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    @ElementCollection(fetch = FetchType.EAGER)
    @SortNatural
    @Column(name = "review")
    Set<String> reviews = new TreeSet<>();
}
