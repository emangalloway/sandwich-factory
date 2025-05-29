package com.plurasight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private LocalDateTime date;
    private String orderId;
    private List<IPriceable> items;

    public Order() {
        this.date = LocalDateTime.now();
        this.orderId = generateOrderId();
        this.items = new ArrayList<>();

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getPrice(){
        double total = 0;
        for (IPriceable item : items) {
            total += item.getPrice();
        }
        return total;
    }
    public String generateOrderId(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String timeStamp = LocalDateTime.now().format(formatter);
        String randomPiece = UUID.randomUUID().toString().substring(0,4).toUpperCase();
        return this.orderId = "ORD- "+timeStamp+"--"+randomPiece;
    }

    public String getOrderDetails(){
        StringBuilder receipt = new StringBuilder();
        receipt.append("Order ID: ").append(orderId).append("\n");
        receipt.append("Date: ").append(date).append("\n");

        for (IPriceable item : items) {
            receipt.append(item.toString()).append("\n");
        }

        receipt.append("\n Total: $").append(String.format("%.2f", getPrice()));
        return receipt.toString();
    }

    public void addPriceable(IPriceable item){
       items.add(item);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sandwichSection = new StringBuilder();
        StringBuilder drinkSection = new StringBuilder();
        StringBuilder chipSection = new StringBuilder();

        for (IPriceable item : items) {
            if (item instanceof Sandwich){
                sandwichSection.append(item);
                item.getPrice();
            } else if (item instanceof  Drink) {
                drinkSection.append(item);
                item.getPrice();
            }else
                chipSection.append(item);
            item.getPrice();
        }
        stringBuilder.append("Sandwich: ").append(sandwichSection).append("\n")
                .append("Drink: ").append(drinkSection).append("\n")
                .append("Chips: ").append(chipSection).append("\n");
        return stringBuilder.toString();
    }
}
