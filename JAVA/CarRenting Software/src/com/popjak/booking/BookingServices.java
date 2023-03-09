package com.popjak.booking;

import com.popjak.car.CarDAO;
import com.popjak.car.CarService;
import com.popjak.user.UserServices;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class BookingServices {

    public static void newBookingRequest(){
        // Method takes care of new booking

        Scanner s = new Scanner(System.in);
        // Method is going to print all cars and ask user to enter desired car SPZ.
        CarService.showAvailableCars("ALL");
        System.out.print("\nEnter SPZ of car u want to book: ");
        String SPZ = s.nextLine().toUpperCase().trim();
        String getCarString = CarService.getCarString(SPZ);

        // Method asks user to enter which user ID they want to register with
        System.out.print("\nSelect userID (uuid long code): ");
        UserServices.viewAllUsers();
        String userID = s.nextLine().toLowerCase().trim();
        String finalString = BookingServices.getFinalStringForExportingToFile(userID,SPZ);

        // if user enters incorrect info it prints this and break the method.
        if (finalString.contains("NULL")){
            System.out.println("Incorrect userID or SPZ try again please.");
            return;
        }

        // IF user enters wrong SPZ
        if (getCarString.equals("NULL")) {
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
                    BookingDAO.exportToDatabase(finalString);
                    System.out.println("Car booked successfully! ✅");
                } else {
                    System.out.println("Booking canceled ❌");
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid input or car doesn't exist in our database try again. ❌");
            }
        }
    }

    private static String getFinalStringForExportingToFile(String uuid, String spz){
        // Helper method creates final string which is exported to database.

        UUID randomUuid = UUID.randomUUID();
        return CarService.getCarString(spz.toUpperCase().trim()) + "," + UserServices.getUserString(uuid.toLowerCase().trim())
                + "  " + randomUuid +"\n";
    }
}
