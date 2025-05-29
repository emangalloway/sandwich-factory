package com.plurasight;

public class Meats extends PremiumTopping {

    public Meats(String name) {
        super(name);
    }

    @Override
    public double getPrice(int size) {
        double total = 0;
        if (size == 4){
            total = 1.00;
        } else if (size == 8) {
            total = 2.00;
        } else if (size == 12) {
            total = 3.00;
        } else
            throw new IllegalArgumentException("Unsupported sandwich size: "+size);
        return total;
    }

    @Override
    public String toString() {
        return getName();
    }
}
