package com.plurasight;

public abstract class AbstractTopping {
    private String name;

    public AbstractTopping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getPrice(int size);

    @Override
    public String toString() {
        return name;
    }
}
