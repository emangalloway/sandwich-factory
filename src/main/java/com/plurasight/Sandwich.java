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

    public Sandwich(int size, boolean isToasted, String breadType) {
        this.extraCheese = extraCheese;
        this.extraMeat = extraMeat;
        this.size = size;
        this.isToasted = isToasted;
        this.breadType = breadType;
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

        //Pricing structure for size
        if (size == 4){
            total = 5.50;
        } else if (size == 8) {
            total = 7.00;
        } else if (size == 12){
            total = 8.50;
        } else
            throw new IllegalArgumentException("Unsupported sandwich size: "+size);

        //Pricing structure for toppings
        for (AbstractTopping abstractTopping : topping) {
            total += abstractTopping.getPrice(size);
        }

        //Pricing structure for extra cheese
        if (extraCheese){
            if (size == 4){
                total += .30;
            } else if (size == 8) {
                total += .60;
            } else if (size == 12) {
                total += .90;
            }
        }

        // Pricing structure for extra meat
        if (extraMeat){
            if (size == 4){
                total += .50;
            } else if (size == 8) {
                total += 1.00;
            } else if (size == 12) {
                total += 1.50;
            }
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder cheeseSection = new StringBuilder();
        StringBuilder meatSection = new StringBuilder();
        StringBuilder regToppingSection = new StringBuilder();
        StringBuilder sauceSection = new StringBuilder();
        for (AbstractTopping abstractTopping : topping) {
            if (abstractTopping instanceof Cheese){
                cheeseSection.append(abstractTopping);
            } else if (abstractTopping instanceof Meats) {
                meatSection.append(abstractTopping);
            } else if (abstractTopping instanceof RegularTopping) {
                regToppingSection.append(abstractTopping);
            } else if (abstractTopping instanceof Sauces) {
                sauceSection.append(abstractTopping);
            } break;

            StringBuilder extraMeat = new StringBuilder();
            for (AbstractTopping meat :topping ) {
                if (abstractTopping instanceof Meats){
                    if (abstractToppin)
                }

            }
            StringBuilder extraCheese = new StringBuilder();

        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sandwich: ").append("\n")
                .append("Size: ").append(getSize()).append("\n")
                .append("Bread: ").append(getBreadType()).append("\n")
                .append("Cheese: ").append(cheeseSection).append("\n")
                .append("Meats: ").append(meatSection).append("\n")
                .append("Extra Meat").append()
                .append("Toppings: ").append(regToppingSection).append("\n")
                .append("Sauces: ").append(sauceSection).append("\n");
        return stringBuilder.toString();
    }
}
