package com.popjak.car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarDAO {

    private static File accessToFile() throws IOException {
        File file = new File("src/com/popjak/data/availableCars.csv");
        if (!file.exists()) {
            file.createNewFile();
            return file;
        }
        return file;
    }
    public static List<String> getAllCars(){
        // Method returns list of cars in availableCars.csv.

        List<String> allCars = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(accessToFile());
            while (scanner.hasNext()) {
                String a = scanner.nextLine();
                allCars.add(a);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return allCars;
    }
}


