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

        System.out.println("==========Select Topping==========");

        Sandwich sandwich = new Sandwich()
        System.out.println();

    }
}
