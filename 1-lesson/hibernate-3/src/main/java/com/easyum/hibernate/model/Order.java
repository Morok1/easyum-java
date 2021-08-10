package com.easyum.hibernate.model;

import lombok.Data;

@Data
public class Order {
    long id;
    Contact weekdayContact;
    Contact holidayContact;
}
