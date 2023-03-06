package com.popjak.car;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarService {

    public static void showCars(String input) {
        /**
         Method searching in database for benzin and diesel cars only
         **/

        // s for scanner
        System.out.println("The list of available cars: \n-----------------------\n");
        try{
            Scanner s = new Scanner(CarDAO.getAccessToFile());
            while (s.hasNext()) {
                // converting CSV to list and analyzing if car exists in the list.
                List<String> list = new ArrayList<>(List.of(s.nextLine().split(",")));

                // if PETROL then output
                if(input.equals("PETROL")){
                    if (list.get(4).equals("BENZIN") || list.get(4).equals("DIESEL")){
                        String detailedView = "SPZ:" + list.get(0) + ", " + list.get(1) + " " + list.get(2) + ", year " + list.get(3) +
                                ", "  + list.get(4) + ", " +  list.get(5) + "€ per day";
                        System.out.println(detailedView);
                    }
                // IF ELECTRIC
                } else if (input.equals("ELECTRIC")) {
                    if (list.get(4).equals("ELECTRIC")){
                        String detailedView = "SPZ:" + list.get(0) + ", " + list.get(1) + " " + list.get(2) + ", year " + list.get(3) +
                                ", "  + list.get(4) + ", " +  list.get(5) + "€ per day";
                        System.out.println(detailedView);
                    }
                } else if (input.equals("ALL")) {
                    String detailedView = list.get(0) + ", " + list.get(1) + " " + list.get(2) + ", year " + list.get(3) +
                            ", "  + list.get(4) + ", " +  list.get(5) + "€ per day";
                    System.out.println(detailedView);
                }
            }
        } catch (IOException e ){
            System.out.println("error");
        }
    }

    public static boolean lookUpCarBySPZ(String SPZ){
        /**
         Method searching in database for electric cars only
         **/

        // s for scanner
        try{
            Scanner s = new Scanner(CarDAO.getAccessToFile());
            while (s.hasNext()) {
                // converting CSV to list and analyzing if car exists in the list.
                List<String> list = new ArrayList<>(List.of(s.nextLine().split(",")));
                if (list.get(0).equals(SPZ.toUpperCase())){
                    // output formatting
                    String detailedView = "SPZ:" + list.get(0) + ", " + list.get(1) + " " + list.get(2) + ", year " + list.get(3) +
                            ", "  + list.get(4) + ", " +  list.get(5) + "€ per day";
                    return true;
                }
            }
        } catch (IOException e ){
            System.out.println("error");
        }
        return false;
    }
    public static BigDecimal getPrice(String SPZ){
        BigDecimal price;
        try{
            Scanner s = new Scanner(CarDAO.getAccessToFile());
            while (s.hasNext()) {
                // converting CSV to list and analyzing if car exists in the list.
                List<String> list = new ArrayList<>(List.of(s.nextLine().split(",")));
                if (list.get(0).equals(SPZ)){
                    price = new BigDecimal(list.get(5));
                    return price;
                }
            }
        } catch (IOException | NumberFormatException e ){
            System.out.println("Invalid input or car doesn't exist in our database try again. ❌");
        }
        return new BigDecimal(0);
    }
}
