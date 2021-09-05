package com.smagin.spring.example3;

public class Battery extends Product {

    private boolean rechargeable;

    public Battery() {
        super();
    }

    public Battery(String name, double price) {
        super(name, price);
    }

    public boolean getRechargeable() {
        return rechargeable;
    }

    // Getters and Setters
    public void setRechargeable(boolean rechargeable) {
        this.rechargeable = rechargeable;
    }
}
