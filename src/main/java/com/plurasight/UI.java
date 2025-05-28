package com.plurasight;

import java.util.Scanner;

public class UI {
    private Order currentOrder;
    private Scanner scanner;
    public UI(){scanner = new Scanner(System.in);
    }

    public void displayMenu(){
        boolean quit = false;
        while (!quit){
            System.out.println("Welcome to the Sandwich Factory\n");
            System.out.println("==========Home Screen==========");
            System.out.println("1.) Start a new order");
            System.out.println("2.) Quit");
            System.out.println("Choose option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    processStartNewOrder();
                    break;
                case "2":
                    quit = true;
                    break;
            }


        }

    }

    public void processStartNewOrder(){
        currentOrder = new Order();
        boolean quit = false;
        while (!quit){
        System.out.println("==========Order Screen==========");
        System.out.println("1.) Add Sandwich");
        System.out.println("2.) Add Drink");
        System.out.println("3.) Add Chips");
        System.out.println("4.) Checkout");
        System.out.println("0.) Cancel Order");
        String choice = scanner.nextLine();

        switch (choice){
            case "1":
                processAddSandwich();
                break;
            case "2":
                processAddDrink();
                break;
            case "3":
                processAddChips();
                break;
            case "4":
                processCheckOut();
                break;
            case "0":
                quit = true;
                break;
        }

        }
    }

    public void processAddSandwich(){
        System.out.println("==========Select size==========");
        System.out.println("1.) 4 inch");
        System.out.println("2.) 8 inch");
        System.out.println("3.) 12 inch");
        String sizeInput = scanner.nextLine();
        int sizeChoice;
        try {
            int menuChoice = Integer.parseInt(sizeInput);
            sizeChoice = switch (menuChoice) {
                case 1 -> 4;
                case 2 -> 8;
                case 3 -> 12;
                default -> {
                    System.out.println("Invalid choice. Defaulting to 4 inch.");
                    yield 4;
                }
            };
            sizeChoice = Integer.parseInt(sizeInput);
        }catch (NumberFormatException e){
            System.out.println("Invalid input. Defaulting to 4 inch");
            sizeChoice = 4;
        }

        System.out.println("==========Select Bread==========");
        System.out.println("1.) White");
        System.out.println("2.) Wheat");
        System.out.println("3.) Rye");
        System.out.println("4.) Wrap");
        String breadChoice = scanner.nextLine();

        System.out.println("==========Toasted==========");
        System.out.println("1.) yes");
        System.out.println("2.) no");
        String toastedInput = scanner.nextLine();
        boolean toasted = toastedInput.equals("1") || toastedInput.equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(breadChoice,toasted,sizeChoice);

        System.out.println("==========Select Meat==========");
        System.out.println("1.) Steak");
        System.out.println("2.) Ham");
        System.out.println("3.) Salami");
        System.out.println("4.) Roast Beef");
        System.out.println("5.) Chicken");
        System.out.println("6.) Bacon");
        String meatChoice = scanner.nextLine();
        System.out.println("Would you like extra meat?");

        System.out.println("==========Select Cheese==========");
        System.out.println("1.) American");
        System.out.println("2.) Provolone");
        System.out.println("3.) Cheddar");
        System.out.println("4.) Swiss");
        String cheeseChoice = scanner.nextLine();

        System.out.println("==========Select Toppings==========");
        System.out.println("Add toppings (Type done when finished)");
        while (true){
            System.out.println("1.) Lettuce");
            System.out.println("2.) Peppers");
            System.out.println("3.) Onions");
            System.out.println("4.) Tomatoes");
            System.out.println("5.) Jalapenos");
            System.out.println("6.) Cucumbers");
            System.out.println("7.) Pickles");
            System.out.println("8.) Guacamole");
            System.out.println("9.) Mushrooms");
            String choice = scanner.nextLine();
            RegularTopping topping = getRegularToppingByChoice(choice);
            if (topping != null) {
                sandwich.addToppings(topping);

            }
        }

        System.out.println("==========Select Sauces==========");

        

    }

    private RegularTopping getRegularToppingByChoice(String choice){
        switch (choice){
            case "1":
                return new RegularTopping("Lettuce");
            case "2":
                return new RegularTopping("Peppers");
            case "3":
                return new RegularTopping("Onions");
            case "4":
                return new RegularTopping("Tomatoes");
            case "5":
                return new RegularTopping("Jalapenos");
            case "6":
                return new RegularTopping("Cucumbers");
            case "7":
                return new RegularTopping("Pickles");
            case "8":
                return new RegularTopping("Guacamole");
            case "9":
                return new RegularTopping("Mushrooms");
            default:return null;
        }
    }
}
