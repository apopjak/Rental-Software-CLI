package com.popjak.booking;

import com.popjak.car.CarService;
import com.popjak.user.UserServices;

import java.math.BigDecimal;
import java.util.Scanner;

public class NewBookingRequest {
    public static void newBookingRequest(){
        // Method takes care of new booking

        Scanner s = new Scanner(System.in);
        // Method is going to print all cars and ask user to enter desired car SPZ.
        CarService.showCars("ALL");
        System.out.print("\nEnter SPZ of car u want to book: ");
        String SPZ = s.nextLine().toUpperCase().trim();
        CarService.lookUpCarBySPZ(SPZ);

        // Method asks user to enter which user ID they want to register with
        System.out.print("\nSelect userID (uuid long code): ");
        UserServices.viewAllUsers();
        String userID = s.nextLine().toLowerCase().trim();
        String finalString = BookingServices.finalStringForDB(userID,SPZ);

        // if user enters incorrect info it prints this and break the method.
        if (finalString.contains("NULL")){
            System.out.println("Incorrect userID or SPZ try again please.");
            return;
        }

        // IF user enters wrong SPZ
        if (!CarService.lookUpCarBySPZ(SPZ)) {
            System.out.println("Car not found ❌");
        } else {
            try{
                // Methos asks user how many days wants to book the car for, and it calculates
                // and print the final bill
                System.out.print("\nEnter number of days u want to register " + SPZ.toUpperCase() + " for: ");
                BigDecimal numOfDays = new BigDecimal(s.nextLine().trim());
                BigDecimal getCarPrice = CarService.getPrice(SPZ);
                BigDecimal finalPrice = numOfDays.multiply(getCarPrice);
                String selection = """
                        Your selection:
                        ----------------""";
                System.out.println(selection);
                System.out.println(numOfDays + " day(s)\n" + getCarPrice + "€ per day" +
                        "\nTotal bill: " + finalPrice +
                        "€\nConfirm the selection by typing 'yes': ");

                String confirmation = s.nextLine().toUpperCase().trim();

                // Method asks user if he agrees to final bill, if YES it print the message
                // and adds the car into booking.csv file as a reference.
                if (confirmation.charAt(0) == 'Y'){
                    BookingServices.exportToDatabase(finalString);
                    System.out.println("Car booked successfully! ✅");
                    System.out.println(BookingServices.getBookingStringForDB(SPZ));
                } else {
                    System.out.println("Booking canceled ❌");
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid input or car doesn't exist in our database try again. ❌");
            }
        }
    }
}
