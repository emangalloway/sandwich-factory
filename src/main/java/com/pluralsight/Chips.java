package com.pluralsight;

public class Chips implements IPriceable {
    private String chipBrand;

    public Chips(String chipBrand) {
        this.chipBrand = chipBrand;
    }

    public String getChipBrand() {
        return chipBrand;
    }

    public void setChipBrand(String chipBrand) {
        this.chipBrand = chipBrand;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String toString() {
        return "Chips: " +chipBrand;
    }
}
