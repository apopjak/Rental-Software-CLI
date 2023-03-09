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
    static void exportToDatabase(String finalString){
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

    static String finalStringForDB(String uuid, String spz){
        // Helper method creates final string which is exported to database.

        UUID randomUuid = UUID.randomUUID();
        return CarService.getCarString(spz.toUpperCase().trim()) + "," + UserServices.getUserString(uuid.toLowerCase().trim())
                + "  " + randomUuid +"\n";
    }

    static String getBookingStringForDB(String SPZ){
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
