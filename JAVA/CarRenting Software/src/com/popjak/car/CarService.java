package com.popjak.car;

import com.popjak.booking.BookingDAO;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarService {



    public static void showAvailableCars(String input) {
        // Method searching in database for cars based on engine type and returns only cars which are not in bookedCARSDB
        // Method checks if car is not in booking.csv file. If yes it is not going to be printed.
        // If input = petrol -> it shows diesel and benzin cars
        // If input = electric -> it shows electric cars
        // if input = all -> it shows all cars together


        // list of cars which are booked already
        List<String> bookedCars = BookingDAO.showBookedCars();
        System.out.println("The list of available cars: \n-----------------------\n");
        try{
            Scanner s = new Scanner(CarDAO.getAccessToFile());
            while (s.hasNext()) {

                // converting CSV to list and analyzing if car exists in the list and generating final string!
                List<String> list = new ArrayList<>(List.of(s.nextLine().split(",")));
                String detailedStringView = "SPZ:" + list.get(0) + ", " + list.get(1) + " " + list.get(2) + ", year " + list.get(3) +
                        ", "  + list.get(4) + ", " +  list.get(5) + "€ per day";

                // if PETROL it returns diesel and benzin available cars
                if(input.equals("PETROL")){
                    if (list.get(4).equals("BENZIN") || list.get(4).equals("DIESEL") && (!bookedCars.contains(list.get(0)))){
                        System.out.println(detailedStringView);
                    }

                // IF ELECTRIC it returns electric available cars
                } else if (input.equals("ELECTRIC")) {
                    if (list.get(4).equals("ELECTRIC") && (!bookedCars.contains(list.get(0)))){
                        System.out.println(detailedStringView);
                    }

                // IF ALL it returns all available cars
                } else if (input.equals("ALL")) {
                    if ((!bookedCars.contains(list.get(0)))){
                        System.out.println(detailedStringView);
                    }
                }
            }
        } catch (IOException e ){
            System.out.println("error");
        }
    }



    public static BigDecimal getPrice(String SPZ){
        // Method is getting daily rent price for car based on SPZ (registration number).

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



    public static String getCarString(String spz) {
        // Method returns a string of the car, which can be used for export to database which contains all booked cars

            try{
                Scanner s = new Scanner(CarDAO.getAccessToFile());
                while (s.hasNext()) {

                    // converting CSV to list and analyzing if car exists in the list.
                    List<String> list = new ArrayList<>(List.of(s.nextLine().split(",")));
                    if (spz.toUpperCase().equals(list.get(0))) {
                        return list.get(0) + "," + list.get(1) + "," + list.get(2) + "," + list.get(3) + "," + list.get(4) + "," + list.get(5);
                    }
                }
            } catch (IOException e ){
                System.out.println(e.getMessage());
            }
        return "NULL";
    }
}
