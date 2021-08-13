package com.easyum.hibernate.recipe3;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Book3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Getter
    @Setter
    String title;
    @ElementCollection
    @OrderColumn(columnDefinition = "int", name = "order_column")
    @Column(name = "review")
    List<String> reviews = new ArrayList<>();
}