package com.easyum.hibernate.recipe2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    String name;
    String address;
    Phone phone;
}
