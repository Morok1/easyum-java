package com.easyum.hibernate.recipe4;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Book4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Getter
    @Setter
    String title;
    @ElementCollection
    @OrderColumn(columnDefinition = "int", name = "order_column")
    @Column(name = "review")
    String[] reviews = new String[0];
}