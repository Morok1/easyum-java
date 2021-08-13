package com.easyum.hibernate.recipe3;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Book3Version {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  int id;
  @Column(unique = true)
  String title;
  @Column
  Integer inventoryCount;
  @Version
  Integer version;
}
