package com.plurasight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderFileManager {
    public void saveOrder(Order order){
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String formattedDate = now.format(formatter);
            String filename = "Receipts/" + formattedDate+ ".txt";
            Files.createDirectories(Paths.get("Receipts"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
            bufferedWriter.write(order.getOrderDetails());
            bufferedWriter.close();

        } catch (Exception e) {
            System.out.println("An error has occurred. ");
        }

    }
}
