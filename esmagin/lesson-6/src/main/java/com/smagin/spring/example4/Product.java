package com.smagin.spring.example4;

import java.text.DecimalFormat;

public abstract class Product {

    private String name;
    private double price;
    private double discount;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    // Getters and Setters
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#%");
        return name + " " + price;
    }
}