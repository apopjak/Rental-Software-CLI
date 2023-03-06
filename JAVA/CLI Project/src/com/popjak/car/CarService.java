package com.popjak.car;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarService {
    private static boolean checkIfCarAdded(Car car){
        /**
         HELPER METHOD
         Checks if the car already exist in database
         **/

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
        /**
         Method adds car into database.
         **/

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


    private static String getEngineType(String string) {
        /**
         HELPER METHOD
         Helps to other methods to use ENUM Engine Type
         **/

        // if user input starts with specific leather then returns type of the engine
        return switch (string.toUpperCase().charAt(0)) {
            case 'B' -> String.valueOf(EngineType.BENZIN);
            case 'D' -> String.valueOf(EngineType.DIESEL);
            case 'E' -> String.valueOf(EngineType.ELECTRIC);
            default -> String.valueOf(EngineType.NONE);
        };
    }
    public static void carLoopUpELECTRIC(){
        /**
         Method searching in database for electric cars only
         **/

        // s for scanner
        System.out.println("Zoznam hladanuch aut: \n-----------------------\n");
        try{
            Scanner s = new Scanner(CarDAO.getAccessToFile());
            while (s.hasNext()) {
                // converting CSV to list and analyzing if car exists in the list.
                List<String> list = new ArrayList<>(List.of(s.nextLine().split(",")));
                if (list.get(4).equals("ELECTRIC")){
                    // output formatting
                    String detailedView = "SPZ:" + list.get(0) + ", " + list.get(1) + " " + list.get(2) + ", rocnik " + list.get(3) +
                            ", "  + list.get(4) + ", " +  list.get(5) + "€ na den";
                    System.out.println(detailedView);
                }
            }
        } catch (IOException e ){
            System.out.println("error");
        }
    }
    public static void carLoopUpPETROL(){
        /**
         Method searching in database for benzin and diesel cars only
         **/

        // s for scanner
        System.out.println("Zoznam hladanuch aut: \n-----------------------\n");
        try{
            Scanner s = new Scanner(CarDAO.getAccessToFile());
            while (s.hasNext()) {
                // converting CSV to list and analyzing if car exists in the list.
                List<String> list = new ArrayList<>(List.of(s.nextLine().split(",")));

                // if benzin or diesel then output
                if (list.get(4).equals("BENZIN") || list.get(4).equals("DIESEL")){
                    // output formatting
                    String detailedView = "SPZ:" + list.get(0) + ", " + list.get(1) + " " + list.get(2) + ", rocnik " + list.get(3) +
                            ", "  + list.get(4) + ", " +  list.get(5) + "€ na den";
                    System.out.println(detailedView);
                }
            }
        } catch (IOException e ){
            System.out.println("error");
        }
    }
}
