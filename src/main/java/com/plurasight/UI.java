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
        }catch (NumberFormatException e){
            System.out.println("Invalid input. Defaulting to 4 inch");
            sizeChoice = 4;
        }

        System.out.println("==========Select Bread==========");
        System.out.println("1.) White");
        System.out.println("2.) Wheat");
        System.out.println("3.) Rye");
        System.out.println("4.) Wrap");
        String breadInput = scanner.nextLine();
        String breadChoice;
        try {
            breadChoice = switch (breadInput){
                case "1"-> "White";
                case "2"-> "Wheat";
                case "3"-> "Rye";
                case "4"-> "Wrap";
                default -> {
                    System.out.println("Bread not found, Defaulting to white.");
                    yield "White";
                }
            };
        }catch (Exception e){
            System.out.println("Bread not found, Defaulting to white.");
            breadChoice = "White";
        }

        System.out.println("==========Toasted==========");
        System.out.println("1.) yes");
        System.out.println("2.) no");
        String toastedInput = scanner.nextLine();
        boolean toasted = toastedInput.equals("1") || toastedInput.equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(sizeChoice,toasted,breadChoice);

        System.out.println("==========Select Meat==========");
        System.out.println("1.) Steak");
        System.out.println("2.) Ham");
        System.out.println("3.) Salami");
        System.out.println("4.) Roast Beef");
        System.out.println("5.) Chicken");
        System.out.println("6.) Bacon");
        String meatChoice = scanner.nextLine();
        Meats meats = getMeatsByChoice(meatChoice);
        Meats extraMeats = null;
        if (meats != null) {
            sandwich.addToppings(meats);

            if (askYesOrNo("Would you like extra meat?")) {
                System.out.println("Select extra meat");
                String extraMeatChoice = scanner.nextLine();
                extraMeats = getMeatsByChoice(extraMeatChoice);
                if (extraMeats != null){
                    System.out.println(meats+", and "+extraMeats+" have been added to your sandwich.");
                    sandwich.setExtraMeat(true);
                    sandwich.addToppings(extraMeats);
                }else {
                    System.out.println(meats+ " has been added to your sandwich.");
                }
            }
        }


        System.out.println("==========Select Cheese==========");
        System.out.println("1.) American");
        System.out.println("2.) Provolone");
        System.out.println("3.) Cheddar");
        System.out.println("4.) Swiss");
        String cheeseChoice = scanner.nextLine();
        Cheese cheese = getCheeseByChoice(cheeseChoice);
        Cheese extraCheese = null;
        if (cheese != null){
            sandwich.addToppings(cheese);
            if (askYesOrNo("Would you like to add extra cheese?")){
                System.out.println("Select extra cheese");
                String extraCheeseChoice = scanner.nextLine();
                extraCheese = getCheeseByChoice(extraCheeseChoice);
                if (extraCheese != null){
                    System.out.println(cheese+", and "+extraCheese+" have been added to your sandwich");
                    sandwich.setExtraCheese(true);
                    sandwich.addToppings(extraCheese);
                }else {
                    System.out.println(cheese+ " has been added to your sandwich. ");
                }
            }
        }

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
            } else if (choice.equalsIgnoreCase("done")) {
                break;
            }
        }
        System.out.println("==========Select sauces==========");
        System.out.println("Add sauces (Type done when finished)");
        while (true) {
            System.out.println("1.) Mayo");
            System.out.println("2.) Mustard");
            System.out.println("3.) Ketchup");
            System.out.println("4.) Ranch");
            System.out.println("5.) Thousands Island");
            System.out.println("6.) Vinaigrette");
            String sauceChoice = scanner.nextLine();
            Sauces sauces = getSaucesByChoice(sauceChoice);
            if (sauces != null) {
                sandwich.addToppings(sauces);
            } else if (sauceChoice.equalsIgnoreCase("done")) {
                break;
            }
        }currentOrder.addPriceable(sandwich);
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
    private Sauces getSaucesByChoice(String choice){
        switch (choice){
            case "1":
                return new Sauces("Mayo");
            case "2":
                return new Sauces("Mustard");
            case "3":
                return new Sauces("Ketchup");
            case "4":
                return new Sauces("Ranch");
            case "5":
                return new Sauces("Thousands Island");
            case "6":
                return new Sauces("Vinaigrette");
            default:return null;
        }
    }
    private Meats getMeatsByChoice(String choice){
        switch (choice){
            case "1":
                return new Meats("Steak");
            case "2":
                return new Meats("Ham");
            case "3":
                return new Meats("Salami");
            case "4":
                return new Meats("Roast Beef");
            case "5":
                return new Meats("Chicken");
            case "6":
                return new Meats("Bacon");
            default:return null;
        }
    }

    private Cheese getCheeseByChoice(String choice){
        switch (choice){
            case "1":
                return new Cheese("American");
            case "2":
                return new Cheese("Provolone");
            case "3":
                return new Cheese("Cheddar");
            case "4":
                return new Cheese("Swiss");
            default:return null;
        }
    }
    private boolean askYesOrNo(String prompt){
        System.out.println(prompt+"(Yes/No)");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Yes")){
            return true;
        }else
            return false;
    }

    public void processAddDrink(){
            System.out.println("==========Select size==========");
            System.out.println("1.) Small");
            System.out.println("2.) Medium");
            System.out.println("3.) Large");
            String sizeInput = scanner.nextLine();
            String sizeChoice;
            try {
                sizeChoice = switch (sizeInput) {
                    case "1" -> "Small";
                    case "2" -> "Medium";
                    case "3" -> "Large";
                    default -> {
                        System.out.println("Invalid choice. Defaulting to Small.");
                        yield "Small";
                    }
                };
            } catch (Exception e) {
                System.out.println("Invalid input. Defaulting to Small");
                sizeChoice = "Small";
            }
            System.out.println("==========Select flavor==========");
            System.out.println("1.) Pepsi");
            System.out.println("2.) Dr.Pepper");
            System.out.println("3.) Fanta");
            System.out.println("4.) Lemonade");
            System.out.println("5.) Sweet Tea");
            System.out.println("6.) Water");
            String flavorInput = scanner.nextLine();
            String flavorChoice;
            try {
                flavorChoice = switch (flavorInput){
                    case "1"-> "Pepsi";
                    case "2" -> "Dr.Pepper";
                    case "3" -> "Fanta";
                    case "4" -> "Lemonade";
                    case "5" -> "Sweet Tea";
                    case "6" -> "Water";
                    default -> {
                        System.out.println("Invalid choice. Defaulting to water");
                        yield "Water";
                    }
                };

            }catch (Exception e){
                System.out.println("Flavor unavailable");
                flavorChoice = "Water";
            }Drink drink = new Drink(flavorChoice,sizeChoice);
            currentOrder.addPriceable(drink);
    }
    public void processAddChips(){
        if (askYesOrNo("Would you like chips")){
            System.out.println("Which brand");
            System.out.println("Doritos");
            System.out.println("Lays");
            System.out.println("Pringles");
            String chipChoice = scanner.nextLine();
            Chips chips = new Chips(chipChoice);
            currentOrder.addPriceable(chips);
        }

    }
    public void processCheckOut() {
        boolean cancel = false;
        while (!cancel) {

            System.out.println("==========Checkout==========");
            System.out.println(currentOrder.getOrderDetails());

            System.out.println("1.) Confirm");
            System.out.println("2.) Cancel");
            String choiceInput = scanner.nextLine();

            if (choiceInput.equalsIgnoreCase("confirm") || choiceInput.equals("1")) {
                OrderFileManager orderFileManager = new OrderFileManager();
                orderFileManager.saveOrder(currentOrder);
                System.out.println("Order confirmed and receipt saved");
                cancel = true;
            } else
                cancel = true;

        }
    }
}
