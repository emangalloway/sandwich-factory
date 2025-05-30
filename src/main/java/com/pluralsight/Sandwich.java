package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements IPriceable {
    private String breadType;
    private boolean isToasted;
    private int size;
    private boolean extraMeat;
    private boolean extraCheese;
    private List<Topping> topping;
    private List<Topping> extraTopping;

    public Sandwich(int size, boolean isToasted, String breadType) {
        this.extraCheese = extraCheese;
        this.extraMeat = extraMeat;
        this.size = size;
        this.isToasted = isToasted;
        this.breadType = breadType;
        this.topping = new ArrayList<>();
        this.extraTopping = new ArrayList<>();
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

    public void addToppings(Topping topping) {
        this.topping.add(topping);
    }
    public void addExtraTopping(Topping topping){
        if (isExtraMeat() || isExtraCheese()){
            this.extraTopping.add(topping);
        }
    }

    @Override
    public double getPrice() {
        double total = 0;

        //Pricing structure for size
        if (size == 4) {
            total = 5.50;
        } else if (size == 8) {
            total = 7.00;
        } else if (size == 12) {
            total = 8.50;
        } else
            throw new IllegalArgumentException("Unsupported sandwich size: " + size);

        //Pricing structure for toppings
        for (Topping topping : this.topping) {
            total += topping.getPrice(size);
        }

        //Pricing structure for extra cheese
        if (extraCheese) {
            if (size == 4) {
                total += .30;
            } else if (size == 8) {
                total += .60;
            } else if (size == 12) {
                total += .90;
            }
        }

        // Pricing structure for extra meat
        if (extraMeat) {
            if (size == 4) {
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
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder meatSection = new StringBuilder();
        StringBuilder extraMeatSection = new StringBuilder();
        StringBuilder cheeseSection = new StringBuilder();
        StringBuilder extraCheeseSection = new StringBuilder();
        StringBuilder regToppingSection = new StringBuilder();
        StringBuilder saucesSection = new StringBuilder();
        List<String> regToppingNames = new ArrayList<>();
        List<String> sauceNames = new ArrayList<>();

        for (Topping top : topping) {
            if (top instanceof Meat){
                meatSection.append(top);
            }
            if (top instanceof Cheese) {
                cheeseSection.append(top);
            }
        }
        //Lambda Expression for adding regular toppings to the list as a String
        topping.stream()
                .filter(t->t instanceof RegularTopping)
                .map(Object::toString)
                .forEach(name -> regToppingNames.add(name));
        //Lambda Expression for adding sauces to the list as a String
        topping.stream()
                .filter(t->t instanceof Sauce)
                .map(Object::toString)
                .forEach(name->sauceNames.add(name));

        for (Topping top : extraTopping) {
            if (top instanceof Meat && isExtraMeat()){
                extraMeatSection.append(top);
            }
            if (top instanceof Cheese && isExtraCheese()){
                extraCheeseSection.append(top);
            }
        }
        regToppingSection.append(String.join(",",regToppingNames));
        saucesSection.append(String.join(",",sauceNames));

        stringBuilder.append("Sandwich: ").append("\n")
                .append("Meat: ").append(meatSection).append("\n")
                .append("Cheese: ").append(cheeseSection).append("\n")
                .append("Toasted: ").append(isToasted()).append("\n")
                .append("Extra Meat: ").append(extraMeatSection).append("\n")
                .append("Extra Cheese: ").append(extraCheeseSection).append("\n")
                .append("Topping: ").append(regToppingSection).append("\n")
                .append("Sauce: ").append(saucesSection).append("\n");
        return stringBuilder.toString();
    }
}