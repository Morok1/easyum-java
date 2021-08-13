package com.easyum.hibernate.recipe1;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Book1 {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  int id;
  @Column(unique = true)
  String title;
}
