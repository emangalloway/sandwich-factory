package com.plurasight;

public class Drink implements IPriceable {
    private String  drinkType;
    private String size;

    public Drink(String drinkType, String size) {
        this.drinkType = drinkType;
        this.size = size;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public double getPrice() {
        double total = 0;
        if (size.equalsIgnoreCase("small")){
            total = 2.00;
        } else if (size.equalsIgnoreCase("medium")) {
            total = 2.50;
        } else if (size.equalsIgnoreCase("large")) {
            total = 3.00;
        }
        return total;
    }

    @Override
    public String toString() {
        return "Drink: "+size +" "+drinkType;
    }
}
