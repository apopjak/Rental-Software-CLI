package com.popjak.car;


import java.io.*;
import java.util.Scanner;

public class CarService {
    private static boolean checkIfCarAdded(Car car){
        try {
            Scanner scanner = new Scanner(CarDAO.getAccessToFile());
            while (scanner.hasNext()){
                if (scanner.nextLine().substring(0,7).contains(car.getSpz())) {
                    return true;
                }
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }return false;
    }
    public static void addCarToDatabase(Car car){
        // adds car into the database IF car is not in there already
        try(
                // closable flushable
                FileWriter fileWriter = new FileWriter(CarDAO.getAccessToFile(),true);
                PrintWriter writter = new PrintWriter(fileWriter);
        ){
            // if car is not in database then add it
            if (!checkIfCarAdded(car)) {
                writter.print(car.toString());
                System.out.println("Auto uspesne pridane do databazi.");

            } else {
                System.out.println("Taketo auto sa uz nachadza v databaze!");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage() + "Car Services");
        }
    }
    public static String getEngineType(String string) {
        // Method returns type of the engine

        // if user input starts with specific leather then returns type of the engine
        return switch (string.toUpperCase().charAt(0)) {
            case 'B' -> String.valueOf(EngineType.BENZIN);
            case 'D' -> String.valueOf(EngineType.DIESEL);
            case 'E' -> String.valueOf(EngineType.ELECTRIC);
            case 'H' -> String.valueOf(EngineType.HYBRID);
            default -> String.valueOf(EngineType.NONE);
        };
    }

}
