package com.plurasight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements IPriceable{
    private String breadType;
    private boolean isToasted;
    private int size;
    private boolean extraMeat;
    private boolean extraCheese;
    private List<AbstractTopping> topping;

    public Sandwich(String breadType, boolean isToasted, int size) {
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.size = size;
        this.topping = new ArrayList<>();
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public void addToppings(AbstractTopping topping){
        this.topping.add(topping);
    }

    @Override
    public double getPrice() {
        double total = 0;

        for (AbstractTopping abstractTopping : topping) {
           total += abstractTopping.getPrice(size);
        }
        double basePrice = 0;
        if (size == 4){
            basePrice = 5.50;
            if (extraCheese){
                total = basePrice + .30;
            }
        } else if (size == 8) {
            basePrice = 7.00;
            if (extraCheese){
                total = basePrice + .60;
            }
        } else if (size == 12){}
        return 0;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "topping=" + topping +
                ", extraCheese=" + extraCheese +
                ", extraMeat=" + extraMeat +
                ", size=" + size +
                ", isToasted=" + isToasted +
                ", breadType='" + breadType + '\'' +
                '}';
    }
}
