package com.plurasight;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class OrderFileManager {
    public void saveOrder(Order order){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Receipts"));
            bufferedWriter.write(order.getOrderDetails());

        } catch (Exception e) {
            System.out.println("An error has occurred. ");
        }

    }
}
