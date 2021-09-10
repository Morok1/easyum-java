package com.smagin.spring.example3;

import lombok.ToString;

public class Disc extends Product {
    @InjectRandom
    private int capacity;

    public Disc() {
        super();
    }

    public Disc(String name, double price) {
        super(name, price);
    }

    public int getCapacity() {
        return capacity;
    }

    // Getters and Setters
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
