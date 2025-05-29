package com.plurasight;

public class Cheese extends AbstractPremiumTopping {

    public Cheese(String name) {
        super(name);
    }


    @Override
    public double getPrice(int size) {
        double total = 0;
        if (size == 4){
            total  = .75;
        } else if (size == 8) {
            total = 1.50;
        } else if (size == 12) {
            total = 2.25;
        } else
            throw new IllegalArgumentException("Unsupported sandwich size: "+size);
        return total;
    }

    @Override
    public String toString() {
        return getName();
    }
}
