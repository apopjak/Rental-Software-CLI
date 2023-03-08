package com.popjak.booking;
import com.popjak.car.CarDAO;
import com.popjak.car.CarService;
import com.popjak.user.UserServices;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class BookingServices {

    public static void viewUserBookedCars(){
        //  Method asks user what ID you want to check,
        //  and then it prints results how many cars use has booked.

        Scanner scanner = new Scanner(System.in);
        UserServices.viewAllUsers();
        System.out.println("Select userID: \n");
        String uuid = scanner.nextLine().toLowerCase().trim();
        try{
            Scanner reader = new Scanner(BookingDAO.getAccessToFile());
            while (reader.hasNext()) {
                // converting CSV to list and analyzing if car exists in the list.
                List<String> list = new ArrayList<>(List.of(reader.nextLine().split(",")));
                if (list.get(6).equals(uuid)){
                    String detailedView = "User: " + list.get(7) + " userID: " + list.get(6).substring(0,5)
                            + "-****-****-****-************ " + list.get(0) + ", " + list.get(1) + " " + list.get(2) +
                            ", " +list.get(3) + ", " + list.get(4) + ", " + list.get(5) + "€ per day";
                    System.out.println(detailedView);
                }
            }
        } catch (IOException e ){
            System.out.println("error");
        }
    }

    public static void viewAllBookings() {
        // Method shows current bookings

        System.out.println("The list of current bookings: \n-----------------------\n");
        try{
            Scanner s = new Scanner(BookingDAO.getAccessToFile());
            while (s.hasNext()) {
                // converting CSV to list and analyzing if car exists in the list.
                List<String> list = new ArrayList<>(List.of(s.nextLine().split(",")));
                String detailedView = "User: " + list.get(7) + " userID: " + list.get(6).substring(0,5)
                        + "-****-****-****-************ " + list.get(0) + ", " + list.get(1) + " " + list.get(2) +
                        ", " +list.get(3) + ", " + list.get(4) + ", " + list.get(5) + "€ per day";
                System.out.println(detailedView);
            }
        } catch (IOException e ){
            System.out.println("error");
        }
    }
    private static void exportToDatabase(String finalString){
        // Method takes final string and exports it to CSV file.

        if (finalString.contains("not found")) System.out.println("Error, incorrect user or car SPZ");
        try (
                FileWriter fileWriter = new FileWriter(BookingDAO.getAccessToFile(),true);
                PrintWriter writer = new PrintWriter(fileWriter);
                ){
            writer.print(finalString);
        }catch (IOException e ) {
            System.out.println(e.getMessage());
        }
    }

    public static void newBooking(){
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
        String finalString = finalStringForDB(userID,SPZ);

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
                    exportToDatabase(finalString);
                    System.out.println("Car booked successfully! ✅");
                    System.out.println(getBookingStringForDB(SPZ));
                } else {
                    System.out.println("Booking canceled ❌");
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid input or car doesn't exist in our database try again. ❌");
            }
        }
    }
    private static String finalStringForDB(String uuid, String spz){
        // Helper method creates final string which is exported to database.

        UUID randomUuid = UUID.randomUUID();
        return CarService.getCarString(spz.toUpperCase().trim()) + "," + UserServices.getUserString(uuid.toLowerCase().trim())
                + "  " + randomUuid +"\n";
    }

    private static String getBookingStringForDB(String SPZ){
        // Method returning string for booking of new car.

        String carString;
        try {
            Scanner s = new Scanner(CarDAO.getAccessToFile());
            while (s.hasNext()) {
                // converting CSV to list and analyzing if car exists in the list.
                List<String> list = new ArrayList<>(List.of(s.nextLine().split(",")));
                if (list.get(0).equals(SPZ.toUpperCase())){
                    carString = list.get(0) + "," + list.get(1) + "," + list.get(2)  + "," +
                            list.get(3) + "," + list.get(4) + "," + list.get(5);
                    return carString;
                }
            }
        } catch (IOException e ){
            System.out.println("error");
        }
        return "null";
    }
}
