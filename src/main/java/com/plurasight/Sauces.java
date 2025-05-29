package com.plurasight;

public class Sauces extends AbstractTopping {
    public Sauces(String name) {
        super(name);
    }

    @Override
    public double getPrice(int size) {
        return 0;
    }

    @Override
    public String toString() {
        return getName();
    }
}
