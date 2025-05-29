package com.plurasight;

public class RegularTopping extends AbstractTopping {
    public RegularTopping(String name) {
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
