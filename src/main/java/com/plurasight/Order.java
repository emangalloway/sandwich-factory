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
        return "Order: " +
                "Date" + date +
                ", Order ID: " + orderId + '\'' +
                ", Items: " + items +
                '}';
    }
}
