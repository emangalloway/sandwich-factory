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
        System.out.println("==========Select Bread==========");
        System.out.println("1.) White");
        System.out.println("2.) Wheat");
        System.out.println("3.) Rye");
        System.out.println("4.) Wrap");
        String breadChoice = scanner.nextLine();

        System.out.println("==========Select Meat==========");
        System.out.println("1.) Steak");
        System.out.println("2.) Ham");
        System.out.println("3.) Salami");
        System.out.println("4.) Roast Beef");
        System.out.println("5.) Chicken");
        System.out.println("6.) Bacon");
        String meatChoice = scanner.nextLine();

        System.out.println("==========Select Cheese==========");
        System.out.println("1.) American");
        System.out.println("2.) Provolone");
        System.out.println("3.) Cheddar");
        System.out.println("4.) Swiss");
        String cheeseChoice = scanner.nextLine();

        System.out.println("==========Select Toppings==========");
        System.out.println("1.) Lettuce");
        System.out.println("2.) Peppers");



        System.out.println("==========Select Sauces==========");

        Sandwich sandwich = new Sandwich()
        System.out.println();

    }
}
