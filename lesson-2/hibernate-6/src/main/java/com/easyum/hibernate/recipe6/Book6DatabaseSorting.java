package com.easyum.hibernate.recipe6;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Book6DatabaseSorting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    @ElementCollection(fetch = FetchType.EAGER)
    @OrderBy("review")
    @Column(name = "review")
    Set<String> reviews = new HashSet<>();
}
