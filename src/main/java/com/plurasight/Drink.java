package com.plurasight;

public class Drink implements IPriceable{
    private String  drinkType;
    private int size;

    public Drink(String drinkType, int size) {
        this.drinkType = drinkType;
        this.size = size;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
