package com.easyum.hibernate.recipe2;

import lombok.Data;

@Data
public class Order {
    long id;
    Contact weekdayContact;
    Contact holidayContact;
}
