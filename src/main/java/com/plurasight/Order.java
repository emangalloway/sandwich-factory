package com.plurasight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime date;
    private String orderId;
    private List<IPriceable> items;

    public Order() {
        this.date = LocalDateTime.now();
        this.orderId = orderId;
        this.items = new ArrayList<>();

    }

    public double getPrice(){
        double total = 0;
        for (IPriceable item : items) {
            total += item.getPrice();
        }
        return total;
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
}
